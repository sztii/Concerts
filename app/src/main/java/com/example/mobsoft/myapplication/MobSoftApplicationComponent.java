package com.example.mobsoft.myapplication;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

import javax.inject.Singleton;

import dagger.Component;

import com.example.mobsoft.myapplication.interactor.InteractorModule;
import com.example.mobsoft.myapplication.interactor.concert.ConcertsInteractor;
import com.example.mobsoft.myapplication.mock.MockNetworkModule;
import com.example.mobsoft.myapplication.repository.RepositoryModule;
import com.example.mobsoft.myapplication.ui.UIModule;
import com.example.mobsoft.myapplication.ui.detail.DetailPresenter;
import com.example.mobsoft.myapplication.ui.list.ConcertsAdapter;
import com.example.mobsoft.myapplication.ui.list.ListActivity;
import com.example.mobsoft.myapplication.ui.detail.DetailActivity;
import com.example.mobsoft.myapplication.ui.list.ListPresenter;
import com.example.mobsoft.myapplication.ui.newconcert.NewconcertActivity;
import com.example.mobsoft.myapplication.ui.newconcert.NewconcertPresenter;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, MockNetworkModule.class})
public interface MobSoftApplicationComponent {
    void inject(ListActivity listActivity);

    void inject(DetailActivity detailActivity);

    void inject(NewconcertActivity newconcertActivity);

    void inject(ConcertsInteractor concertsInteractor);

    void inject(ListPresenter listPresenter);

    void inject(DetailPresenter detailPresenter);

    void inject(NewconcertPresenter newconcertPresenter);

    void inject(ConcertsAdapter concertsAdapter);

    void inject(MobSoftApplication mobSoftApplication);
}
