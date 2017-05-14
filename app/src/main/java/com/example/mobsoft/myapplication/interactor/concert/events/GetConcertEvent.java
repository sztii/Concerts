package com.example.mobsoft.myapplication.interactor.concert.events;

import com.example.mobsoft.myapplication.model.Concert;

import java.util.List;

/**
 * Created by gaaaron on 2017. 04. 03..
 */

public class GetConcertEvent {
    private int code;
    private Concert concert;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public GetConcertEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

//</editor-fold>
}
