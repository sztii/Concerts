package com.example.mobsoft.myapplication.ui.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mobsoft.myapplication.MobSoftApplication;
import com.example.mobsoft.myapplication.R;
import com.example.mobsoft.myapplication.model.Concert;
import com.example.mobsoft.myapplication.ui.detail.DetailActivity;
import com.example.mobsoft.myapplication.ui.list.ListScreen;
import com.example.mobsoft.myapplication.ui.newconcert.NewconcertActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class ListActivity  extends AppCompatActivity implements ListScreen {
    @Inject
    ListPresenter listPresenter;

    private RecyclerView recyclerView;
    private ConcertsAdapter adapter;
    private List<Concert> concerts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MobSoftApplication.injector.inject(this);

        recyclerView = (RecyclerView)findViewById(R.id.rvConcerts);

        adapter = new ConcertsAdapter(concerts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listPresenter.attachScreen(this);
        listPresenter.updateConcerts();
    }

    @Override
    protected void onStop() {
        super.onStop();
        listPresenter.detachScreen();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh_menu:
                listPresenter.updateConcerts();
                return true;
            case R.id.new_menu:
                Intent intent = new Intent(getApplicationContext(), NewconcertActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showList() {
        concerts.clear();
        concerts.addAll(listPresenter.getConcerts());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showDetail(Concert concert) {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("concert_id", concert.getId());
        startActivity(intent);
    }

    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


}
