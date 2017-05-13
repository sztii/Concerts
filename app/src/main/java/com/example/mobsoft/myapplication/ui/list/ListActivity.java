package com.example.mobsoft.myapplication.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mobsoft.myapplication.MobSoftApplication;
import com.example.mobsoft.myapplication.R;
import com.example.mobsoft.myapplication.model.Concert;
import com.example.mobsoft.myapplication.ui.main.MainPresenter;
import com.example.mobsoft.myapplication.ui.list.ListScreen;
import com.example.mobsoft.myapplication.ui.newconcert.NewconcertActivity;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class ListActivity  extends AppCompatActivity implements ListScreen {
    @Inject
    ListPresenter listPresenter;

    Button btnNewConcert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MobSoftApplication.injector.inject(this);

        btnNewConcert = (Button)findViewById(R.id.btnNewConcert);

        btnNewConcert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewconcertActivity.class);
                startActivity(intent);
            }
        });
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
    public void showList(List<Concert> concerts) {

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
    public void selectConcert(int id) {

    }

    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


}
