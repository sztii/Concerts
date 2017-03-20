package com.example.mobsoft.myapplication;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

import javax.inject.Singleton;

import dagger.Component;
import com.example.mobsoft.myapplication.ui.UIModule;
import com.example.mobsoft.myapplication.ui.list.ListActivity;
import com.example.mobsoft.myapplication.ui.detail.DetailActivity;
import com.example.mobsoft.myapplication.ui.main.MainActivity;
import com.example.mobsoft.myapplication.ui.newconcert.NewconcertActivity;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(ListActivity listActivity);

    void inject(DetailActivity detailActivity);

    void inject(NewconcertActivity newconcertActivity);
}
