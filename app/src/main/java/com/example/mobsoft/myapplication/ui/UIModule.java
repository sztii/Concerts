package com.example.mobsoft.myapplication.ui;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

import dagger.Module;
import dagger.Provides;
import com.example.mobsoft.myapplication.ui.list.ListPresenter;
import com.example.mobsoft.myapplication.ui.detail.DetailPresenter;
import com.example.mobsoft.myapplication.ui.newconcert.NewconcertPresenter;


import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;
import de.greenrobot.event.EventBus;

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

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}