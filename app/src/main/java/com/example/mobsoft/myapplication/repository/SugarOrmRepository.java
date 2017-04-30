package com.example.mobsoft.myapplication.repository;

import android.content.Context;

import com.example.mobsoft.myapplication.model.Concert;
import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by gaaaron on 2017. 04. 03..
 */

public class SugarOrmRepository implements Repository {
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Concert> getConcerts() {
        return SugarRecord.listAll(Concert.class);
    }

    @Override
    public Concert getConcert(Long id) {
        return SugarRecord.findById(Concert.class, id) ;
    }

    @Override
    public void saveConcert(Concert concert) {
        SugarRecord.saveInTx(concert);
    }

    @Override
    public boolean isInDB(Concert concert) {
        return SugarRecord.findById(Concert.class, concert.getId()) != null;
    }
}
