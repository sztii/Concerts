package com.example.mobsoft.myapplication;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

import javax.inject.Singleton;

import dagger.Component;
import com.example.mobsoft.myapplication.ui.UIModule;
import com.example.mobsoft.myapplication.ui.main.MainActivity;

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

}
