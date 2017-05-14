package com.example.mobsoft.myapplication;

import com.example.mobsoft.myapplication.interactor.InteractorModule;
import com.example.mobsoft.myapplication.mock.MockNetworkModule;
import com.example.mobsoft.myapplication.repository.TestRepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}