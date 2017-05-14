package com.example.mobsoft.myapplication.ui.list;

import android.util.Log;

import com.example.mobsoft.myapplication.interactor.concert.ConcertsInteractor;
import com.example.mobsoft.myapplication.interactor.concert.events.GetConcertsEvent;
import com.example.mobsoft.myapplication.interactor.concert.events.SaveConcertEvent;
import com.example.mobsoft.myapplication.model.Concert;
import com.example.mobsoft.myapplication.ui.Presenter;
import com.example.mobsoft.myapplication.ui.list.event.ConcertClickEvent;
import com.example.mobsoft.myapplication.ui.list.event.ConcertFavouriteClickEvent;

import java.util.ArrayList;
import java.util.List;
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

    private List<Concert> concerts = new ArrayList<>();

    public ListPresenter() {
        injector.inject(this);
    }

    @Override
    public void attachScreen(ListScreen screen) {
        super.attachScreen(screen);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void updateConcerts() {
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
            Log.e("Networking", "Error reading concerts", event.getThrowable());
        } else {
            concerts.clear();
            concerts = event.getConcerts();
            if (screen != null) {
                screen.showList();
            }
        }
    }

    public void onEventMainThread(ConcertClickEvent event) {
        if (screen != null) {
            screen.showDetail(event.getConcert());
        }
    }

    public void onEventMainThread(final ConcertFavouriteClickEvent event) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Concert concert = event.getConcert();
                concert.setIsFavourite(!concert.getIsFavourite());
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
            for (Concert concert : concerts) {
                if (concert.getId().equals(event.getConcert().getId())) {
                    concert.setIsFavourite(event.getConcert().getIsFavourite());
                    if (screen != null) {
                        screen.showList();
                    }
                }
            }
        }
    }

    public List<Concert> getConcerts() {
        return concerts;
    }
}
