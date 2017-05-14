package com.example.mobsoft.myapplication.ui.newconcert;

import android.util.Log;

import com.example.mobsoft.myapplication.interactor.concert.ConcertsInteractor;
import com.example.mobsoft.myapplication.interactor.concert.events.GetConcertEvent;
import com.example.mobsoft.myapplication.interactor.concert.events.SaveConcertEvent;
import com.example.mobsoft.myapplication.model.Concert;
import com.example.mobsoft.myapplication.ui.Presenter;
import com.example.mobsoft.myapplication.ui.detail.DetailScreen;
import com.example.mobsoft.myapplication.ui.list.ListScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.myapplication.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class NewconcertPresenter extends Presenter<NewconcertScreen> {

    @Inject
    ConcertsInteractor concertsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    public NewconcertPresenter() {
        injector.inject(this);
    }

    @Override
    public void attachScreen(NewconcertScreen screen) {
        super.attachScreen(screen);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void saveConcert(final Concert concert) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                concertsInteractor.saveConcert(concert);
            }
        });
    }

    public void onEventMainThread(SaveConcertEvent event) {

        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error saving concert", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showListScreen();
            }
        }
    }
}
