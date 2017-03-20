package com.example.mobsoft.myapplication.ui.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.mobsoft.myapplication.MobSoftApplication;
import com.example.mobsoft.myapplication.R;
import com.example.mobsoft.myapplication.ui.detail.DetailPresenter;
import com.example.mobsoft.myapplication.ui.detail.DetailScreen;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 20..
 */


public class DetailActivity extends AppCompatActivity implements DetailScreen {
    @Inject
    DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailPresenter.detachScreen();
    }

    @Override
    public void showDetails(int id) {


    }

    public void navigateBack() {


    }


}
