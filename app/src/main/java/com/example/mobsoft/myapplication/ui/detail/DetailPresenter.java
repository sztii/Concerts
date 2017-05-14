package com.example.mobsoft.myapplication.ui.detail;

import android.util.Log;

import com.example.mobsoft.myapplication.interactor.concert.ConcertsInteractor;
import com.example.mobsoft.myapplication.interactor.concert.events.GetConcertEvent;
import com.example.mobsoft.myapplication.interactor.concert.events.GetConcertsEvent;
import com.example.mobsoft.myapplication.model.Concert;
import com.example.mobsoft.myapplication.ui.Presenter;
import com.example.mobsoft.myapplication.ui.list.ListScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.myapplication.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class DetailPresenter extends Presenter<DetailScreen> {

    @Inject
    ConcertsInteractor concertsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    private Concert concert;

    public DetailPresenter() {
        injector.inject(this);
    }

    @Override
    public void attachScreen(DetailScreen screen) {
        super.attachScreen(screen);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void updateConcert(final Long id) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                concertsInteractor.getConcert(id);
            }
        });
    }

    public void onEventMainThread(GetConcertEvent event) {

        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading concert", event.getThrowable());
        } else if (event.getConcert() == null) {
            if (screen != null) {
                screen.showMessage("error");
            }
        } else {
            concert = event.getConcert();
            if (screen != null) {
                screen.showDetails();
            }
        }
    }

    public Concert getConcert() {
        return concert;
    }
}
