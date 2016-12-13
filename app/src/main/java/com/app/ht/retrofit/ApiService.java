package com.app.ht.retrofit;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by niranjan on 03/01/16.
 * Custom interface to declare all API calls
 */
public interface ApiService {

    @GET("api/v1/booking/slots/all")
    Call<String> fetchAppointmentSlots(@QueryMap Map<String, String> requestParams);

}
