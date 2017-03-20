package com.example.mobsoft.myapplication.ui.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.mobsoft.myapplication.MobSoftApplication;
import com.example.mobsoft.myapplication.R;
import com.example.mobsoft.myapplication.ui.main.MainPresenter;
import com.example.mobsoft.myapplication.ui.list.ListScreen;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class ListActivity  extends AppCompatActivity implements ListScreen {
    @Inject
    ListPresenter listPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        listPresenter.detachScreen();
    }

    @Override
    public void showList() {

    }

    @Override
    public void newConcert() {

    }

    @Override
    public void favourite() {

    }

    @Override
    public void deleteFavourite() {

    }

    @Override
    public void selectConcert() {

    }

}
