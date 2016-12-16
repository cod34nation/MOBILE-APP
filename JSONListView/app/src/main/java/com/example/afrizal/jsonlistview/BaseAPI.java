package com.example.afrizal.jsonlistview;

import com.example.afrizal.jsonlistview.Model.ModelPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


/**
 * Created by AFRIZAL on 12/15/2016.
 */
public interface BaseAPI {
    String baseUrl="http://demo7104902.mockable.io/";

    @GET("dedek")
    Call<List<ModelPhoto>> GetPhotoList();

    class  Factory{
        public static BaseAPI create(){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

           return retrofit.create(BaseAPI.class);
        }
    }
}
