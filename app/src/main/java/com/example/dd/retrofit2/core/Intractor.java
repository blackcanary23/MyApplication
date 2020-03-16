package com.example.dd.retrofit2.core;

import android.content.Context;
import android.util.Log;
import com.example.dd.retrofit2.model.AndroidVersion;
import com.example.dd.retrofit2.model.JSONResponse;
import com.example.dd.retrofit2.model.RequestInterface;
import java.util.ArrayList;
import java.util.Arrays;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Intractor implements GetDataContract.Interactor{
    private GetDataContract.onGetDataListener mOnGetDatalistener;
    private ArrayList<AndroidVersion> data;

    public Intractor(GetDataContract.onGetDataListener mOnGetDatalistener){
        this.mOnGetDatalistener = mOnGetDatalistener;
    }

    @Override
    public void initRetrofitCall(Context context, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                mOnGetDatalistener.onSuccess("List Size: " + data.size(), data);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });
    }
}