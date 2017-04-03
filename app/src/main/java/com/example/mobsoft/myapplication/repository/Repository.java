package com.example.mobsoft.myapplication.repository;

import android.content.Context;

import com.example.mobsoft.myapplication.model.Concert;

import java.util.List;

/**
 * Created by gaaaron on 2017. 04. 03..
 */

public interface Repository {

    void open(Context context);

    void close();

    List<Concert> getConcerts();

    Concert getConcert(Long id);

    void saveConcert(Concert concert);

    boolean isInDB(Concert concert);

}
