package com.example.mobsoft.myapplication;

/**
 * Created by mobsoft on 2017. 03. 20..
 */


import android.app.Application;

import com.example.mobsoft.myapplication.repository.Repository;
import com.example.mobsoft.myapplication.ui.UIModule;

import javax.inject.Inject;

public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    @Inject
    Repository repository;

    public void setInjector(MobSoftApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
        injector.inject(this);

        repository.open(this);
    }
}