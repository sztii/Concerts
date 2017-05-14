package com.example.mobsoft.myapplication.interactor.concert;

import com.example.mobsoft.myapplication.MobSoftApplication;
import com.example.mobsoft.myapplication.interactor.concert.events.GetConcertEvent;
import com.example.mobsoft.myapplication.interactor.concert.events.GetConcertsEvent;
import com.example.mobsoft.myapplication.interactor.concert.events.SaveConcertEvent;
import com.example.mobsoft.myapplication.model.Concert;
import com.example.mobsoft.myapplication.network.concerts.ConcertsApi;
import com.example.mobsoft.myapplication.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import retrofit2.Call;


/**
 * Created by gaaaron on 2017. 04. 03..
 */

public class ConcertsInteractor {
    @Inject
    ConcertsApi concertsApi;
    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public ConcertsInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getConcerts() {
        GetConcertsEvent event = new GetConcertsEvent();
        try {
            List<Concert> concerts = repository.getConcerts();
            event.setConcerts(concerts);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveConcert(Concert concert) {

        SaveConcertEvent event = new SaveConcertEvent();
        event.setConcert(concert);
        try {
            concertsApi.concertPost(concert).execute();
            repository.saveConcert(concert);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getConcert(Long id) {

        GetConcertEvent event = new GetConcertEvent();
        try {
            Concert concert = repository.getConcert(id);
            event.setConcert(concert);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }


}
