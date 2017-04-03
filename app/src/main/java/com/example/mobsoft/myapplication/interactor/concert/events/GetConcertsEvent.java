package com.example.mobsoft.myapplication.interactor.concert.events;

import com.example.mobsoft.myapplication.model.Concert;

import java.util.List;

/**
 * Created by gaaaron on 2017. 04. 03..
 */

public class GetConcertsEvent {
    private int code;
    private List<Concert> concerts;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public GetConcertsEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

//</editor-fold>
}
