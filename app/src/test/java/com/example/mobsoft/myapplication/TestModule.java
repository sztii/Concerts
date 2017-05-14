package com.example.mobsoft.myapplication;

import android.content.Context;


import com.example.mobsoft.myapplication.ui.UIModule;
import com.example.mobsoft.myapplication.ui.detail.DetailPresenter;
import com.example.mobsoft.myapplication.ui.list.ListPresenter;
import com.example.mobsoft.myapplication.ui.newconcert.NewconcertPresenter;
import com.example.mobsoft.myapplication.utils.UiExecutor;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

@Module
public class TestModule {

    private final UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }

    @Provides
    @Singleton
    public ListPresenter provideListPresenter() {
        return UIModule.provideListPresenter();
    }

    @Provides
    @Singleton
    public DetailPresenter provideDetailPresenter() {
        return UIModule.provideDetailPresenter();
    }

    @Provides
    @Singleton
    public NewconcertPresenter provideNewconcertPresenter() {
        return UIModule.provideNewconcertPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}