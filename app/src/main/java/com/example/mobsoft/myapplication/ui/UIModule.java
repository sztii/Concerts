package com.example.mobsoft.myapplication.ui;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

import dagger.Module;
import dagger.Provides;
import com.example.mobsoft.myapplication.ui.list.ListPresenter;
import com.example.mobsoft.myapplication.ui.main.MainPresenter;
import com.example.mobsoft.myapplication.ui.detail.DetailPresenter;
import com.example.mobsoft.myapplication.ui.newconcert.NewconcertPresenter;
import android.content.Context;
import javax.inject.Singleton;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public ListPresenter provideListPresenter() {
        return new ListPresenter();
    }

    @Provides
    @Singleton
    public DetailPresenter provideDetailPresenter() {
        return new DetailPresenter();
    }

    @Provides
    @Singleton
    public NewconcertPresenter provideNewconcertPresenter() {
        return new NewconcertPresenter();
    }

}