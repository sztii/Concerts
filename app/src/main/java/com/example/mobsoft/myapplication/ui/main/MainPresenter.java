package com.example.mobsoft.myapplication.ui.main;

import com.example.mobsoft.myapplication.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class MainPresenter extends Presenter<MainScreen> {

    private static MainPresenter instance = null;

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}