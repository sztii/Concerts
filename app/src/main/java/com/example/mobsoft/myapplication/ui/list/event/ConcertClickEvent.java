package com.example.mobsoft.myapplication.ui.list.event;

import com.example.mobsoft.myapplication.model.Concert;

public class ConcertClickEvent {
    private Concert concert;

    public ConcertClickEvent(Concert concert) {
        this.concert = concert;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }
}
