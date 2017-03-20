package com.example.mobsoft.myapplication;

/**
 * Created by mobsoft on 2017. 03. 20..
 */


import android.app.Application;

import com.example.mobsoft.myapplication.ui.UIModule;

public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}