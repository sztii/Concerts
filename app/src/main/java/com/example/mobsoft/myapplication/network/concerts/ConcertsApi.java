package com.example.mobsoft.myapplication.network.concerts;



import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import com.example.mobsoft.myapplication.model.Concert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ConcertsApi {
  
  /**
   * Get the concerts
   * Returns all the concerts
   * @return Call<List<Concert>>
   */
  
  @GET("concert")
  Call<List<Concert>> concertGet();
    

  
  /**
   * Add a new_concert concert
   * 
   * @param body 
   * @return Call<Void>
   */
  
  @POST("concert")
  Call<Void> concertPost(
    @Body Concert body
  );

  
  /**
   * Find concert by ID
   * Returns a single concert
   * @param id ID of concert to return
   * @return Call<Concert>
   */
  
  @GET("concert/{id}")
  Call<Concert> concertIdGet(
    @Path("id") Long id
  );

  
}
