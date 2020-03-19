package com.example.dd.retrofit2.core;

import android.support.annotation.NonNull;
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


public class Interactor implements GetDataContract.Interactor{

    private GetDataContract.onGetDataListener mOnGetDatalistener;

    Interactor(GetDataContract.onGetDataListener mOnGetDatalistener){

        this.mOnGetDatalistener = mOnGetDatalistener;
    }

    @Override
    public void initRetrofitCall() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {

            @Override
            public void onResponse(@NonNull Call<JSONResponse> call, @NonNull Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                assert jsonResponse != null;
                ArrayList<AndroidVersion> data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                mOnGetDatalistener.onSuccess("List Size: " + data.size(), data);
            }

            @Override
            public void onFailure(@NonNull Call<JSONResponse> call, @NonNull Throwable t) {

                Log.d("Error",t.getMessage());
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });
    }
}