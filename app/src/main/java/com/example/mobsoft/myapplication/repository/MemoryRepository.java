package com.example.mobsoft.myapplication.repository;

import android.content.Context;
import android.util.Log;

import com.example.mobsoft.myapplication.model.Concert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaaaron on 2017. 04. 03..
 */

public class MemoryRepository implements Repository {
    private static final long MINUTE = 60 * 1000;
    private static long maxId = 0;

    public static List<Concert> concerts;

    @Override
    public void open(Context context) {
        Concert concert1 = new Concert(1L, "Concert 1", "2011.06.07", "Somewhere 1", 1000, "web1", true);
        Concert concert2 = new Concert(2L, "Concert 2", "2012.06.07", "Somewhere 2", 2000, "web2", false);
        Concert concert3 = new Concert(3L, "Concert 3", "2013.06.07", "Somewhere 3", 3000, "web3", false);
        Concert concert4 = new Concert(4L, "Concert 4", null, "Somewhere 4", 4000, "web4", true);
        Concert concert5 = new Concert(5L, "Concert 5", "2015.06.07", "Somewhere 5", 5000, "web5", true);
        maxId = 5;

        concerts = new ArrayList<>();
        concerts.add(concert1);
        concerts.add(concert2);
        concerts.add(concert3);
        concerts.add(concert4);
        concerts.add(concert5);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Concert> getConcerts() {
        return new ArrayList<>(concerts);
    }

    @Override
    public Concert getConcert(Long id) {
        for (Concert concert : concerts) {
            if (concert.getId().equals(id)) return concert;
        }
        return null;
    }

    @Override
    public void saveConcert(Concert concert) {
        Concert dbConcert = null;
        if (isInDB(concert) && (dbConcert = getConcert(concert.getId())) != null) {
            dbConcert.set(concert);
        } else {
            if (concert.getId() == null) {
                maxId++;
                concert.setId(maxId);
            }
            concerts.add(concert);
        }
    }

    @Override
    public boolean isInDB(Concert concert) {
        for (Concert dbConcert : concerts) {
            if (dbConcert.getId().equals(concert.getId())) return true;
        }
        return false;
    }
}
