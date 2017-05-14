package com.example.mobsoft.myapplication.ui.newconcert;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mobsoft.myapplication.MobSoftApplication;
import com.example.mobsoft.myapplication.R;
import com.example.mobsoft.myapplication.model.Concert;
import com.example.mobsoft.myapplication.ui.detail.DetailPresenter;
import com.example.mobsoft.myapplication.ui.detail.DetailScreen;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class NewconcertActivity extends AppCompatActivity implements NewconcertScreen {
    @Inject
    NewconcertPresenter newconcertPresenter;

    private TextInputEditText nameEt;
    private TextInputEditText placeEt;
    private TextInputEditText dateEt;
    private TextInputEditText priceEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newconcert);

        MobSoftApplication.injector.inject(this);

        nameEt = (TextInputEditText)findViewById(R.id.name_et);
        placeEt = (TextInputEditText)findViewById(R.id.place_et);
        dateEt = (TextInputEditText)findViewById(R.id.date_et);
        priceEt = (TextInputEditText)findViewById(R.id.price_et);
    }

    @Override
    protected void onStart() {
        super.onStart();
        newconcertPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        newconcertPresenter.detachScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_new, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_menu:
                String name = nameEt.getText().toString();
                if (name.isEmpty()) {
                    showMessage("Name can't be empty");
                    return true;
                }
                String place = placeEt.getText().toString();
                String date = dateEt.getText().toString();
                int price = 0;

                if (!priceEt.getText().toString().isEmpty()) {
                    try {
                        price = Integer.parseInt(priceEt.getText().toString());
                    } catch (Exception e) {
                        showMessage("Price must be an integer");
                        return true;
                    }
                }

                if (price < 0) {
                    showMessage("Price can't be negative");
                    return true;
                }

                Concert concert = new Concert();
                concert.setName(name);
                concert.setPlace(place);
                concert.setDate(date);
                concert.setPrice(price);
                newconcertPresenter.saveConcert(concert);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showListScreen() {
        onBackPressed();
    }

    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}