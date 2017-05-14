package com.example.mobsoft.myapplication.ui.list;

import com.example.mobsoft.myapplication.model.Concert;

import java.util.List;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public interface ListScreen {
    void showList();

    void showDetail(Concert concert);

    void showMessage(String text);
}
