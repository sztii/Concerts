package com.example.mobsoft.myapplication.ui.list;

import android.util.Log;

import com.example.mobsoft.myapplication.interactor.concert.ConcertsInteractor;
import com.example.mobsoft.myapplication.interactor.concert.events.GetConcertsEvent;
import com.example.mobsoft.myapplication.model.Concert;
import com.example.mobsoft.myapplication.ui.main.MainScreen;
import com.example.mobsoft.myapplication.ui.Presenter;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.mobsoft.myapplication.MobSoftApplication.injector;


/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class ListPresenter extends Presenter<ListScreen> {

    @Inject
    ConcertsInteractor concertsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;


    public ListPresenter() {
    }

    @Override
    public void attachScreen(ListScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getConcerts() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                concertsInteractor.getConcerts();
            }
        });
    }

    public void onEventMainThread(GetConcertsEvent event) {

        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                for(Concert c : event.getConcerts()){
                    screen.showMessage(c.getName());
                }
            }
        }
    }
}
