package com.example.mobsoft.myapplication.ui.list;

import com.example.mobsoft.myapplication.model.Concert;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public interface ListScreen {
    void showList(List<Concert> concerts);

    void newConcert();

    void favourite();

    void deleteFavourite();

    void selectConcert(int id);

    void showMessage(String text);
}
