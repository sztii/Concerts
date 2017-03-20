package com.example.mobsoft.myapplication.ui;

/**
 * Created by mobsoft on 2017. 03. 20..
 */


import dagger.Module;
import dagger.Provides;
import com.example.mobsoft.myapplication.ui.main.MainPresenter;
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

}