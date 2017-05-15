package com.example.mobsoft.myapplication.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobsoft.myapplication.MobSoftApplication;
import com.example.mobsoft.myapplication.R;
import com.example.mobsoft.myapplication.model.Concert;
import com.example.mobsoft.myapplication.ui.detail.DetailPresenter;
import com.example.mobsoft.myapplication.ui.detail.DetailScreen;
import com.example.mobsoft.myapplication.ui.newconcert.NewconcertActivity;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import static android.R.attr.name;

/**
 * Created by mobsoft on 2017. 03. 20..
 */


public class DetailActivity extends AppCompatActivity implements DetailScreen {
    @Inject
    DetailPresenter detailPresenter;

    private Long concertId;
    private TextView dateTv;
    private TextView placeTv;
    private TextView priceTv;
    private TextView websiteTv;

    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        MobSoftApplication.injector.inject(this);

        dateTv = (TextView)findViewById(R.id.date_tv);
        placeTv = (TextView)findViewById(R.id.place_tv);
        priceTv = (TextView)findViewById(R.id.price_tv);
        websiteTv = (TextView)findViewById(R.id.website_tv);

        MobSoftApplication application = (MobSoftApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailPresenter.attachScreen(this);

        concertId = getIntent().getExtras().getLong("concert_id");

        if (concertId != null) {
            detailPresenter.updateConcert(concertId);
        }


        mTracker.setScreenName("Image~DetailActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onStop() {
        super.onStop();
        detailPresenter.detachScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh_menu:
                if (concertId != null) {
                    detailPresenter.updateConcert(concertId);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showDetails() {
        Concert concert = detailPresenter.getConcert();
        if (concert != null) {
            setTitle(concert.getName());
            dateTv.setText(concert.getDate() == null ? "" : concert.getDate());
            placeTv.setText(concert.getPlace() == null ? "" : concert.getPlace());
            priceTv.setText(concert.getPrice() == null ? "0 HUF" : concert.getPrice() + " HUF");
            websiteTv.setText(concert.getWebsite() == null ? "" : concert.getWebsite());
        }
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }


    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


}
