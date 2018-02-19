package com.android.restapiexercise.data.network;

import com.android.restapiexercise.data.model.Facts;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Apple on 19/02/18.
 */

public interface ApiInterface {

    @POST("facts.json")
    Call<Facts> getFacts();
}
