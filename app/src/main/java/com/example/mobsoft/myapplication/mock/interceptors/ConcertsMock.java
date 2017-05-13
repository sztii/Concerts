package com.example.mobsoft.myapplication.mock.interceptors;

/**
 * Created by gaaaron on 2017. 05. 08..
 */

import android.net.Uri;

import com.example.mobsoft.myapplication.network.NetworkConfig;
import com.example.mobsoft.myapplication.repository.MemoryRepository;
import com.example.mobsoft.myapplication.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.mobsoft.myapplication.mock.interceptors.MockHelper.makeResponse;

public class ConcertsMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "concert") && request.method().equals("POST")) {
            responseString = "";
            responseCode = 200;

            /**
             * Simple Get Example
             */

		}else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "concert") && request.method().equals("Get")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.getConcerts());
			responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}