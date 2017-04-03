package com.example.mobsoft.myapplication.interactor;

import com.example.mobsoft.myapplication.interactor.concert.ConcertsInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gaaaron on 2017. 04. 03..
 */


@Module
public class InteractorModule {

    @Provides
    public ConcertsInteractor provideFavourites() {
        return new ConcertsInteractor();
    }

}
