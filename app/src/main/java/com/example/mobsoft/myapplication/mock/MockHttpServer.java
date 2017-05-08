package com.example.mobsoft.myapplication.mock;

/**
 * Created by gaaaron on 2017. 05. 08..
 */

import com.example.mobsoft.myapplication.mock.interceptors.MockInterceptor;

import okhttp3.Request;
import okhttp3.Response;

public class MockHttpServer {

    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}