package com.example.mobsoft.myapplication.repository;

import android.content.Context;

import com.example.mobsoft.myapplication.model.Concert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaaaron on 2017. 04. 03..
 */

public class MemoryRepository implements Repository  {
    private static final long MINUTE = 60 * 1000;

    public static List<Concert> concerts;

    @Override
    public void open(Context context) {
        Concert concert1 = new Concert(1L, "Concert 1");
        Concert concert2 = new Concert(3L, "Concert 2");

        concerts = new ArrayList<>();
        concerts.add(concert1);
        concerts.add(concert2);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Concert> getConcerts() {
        return concerts;
    }

    @Override
    public void saveConcert(Concert concert) {
        concerts.add(concert);
    }

    @Override
    public boolean isInDB(Concert concert) {
        return concerts.contains(concert);
    }
}
