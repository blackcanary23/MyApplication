package com.example.dd.retrofit2.core;

import android.content.Context;
import com.example.dd.retrofit2.model.AndroidVersion;
import java.util.ArrayList;


public class Presenter implements GetDataContract.Presenter, GetDataContract.onGetDataListener {

    private GetDataContract.View mGetDataView;
    private Interactor mIntractor;

    public Presenter(GetDataContract.View mGetDataView){

        this.mGetDataView = mGetDataView;
        mIntractor = new Interactor(this);
    }

    @Override
    public void getDataFromURL(Context context) {

        mIntractor.initRetrofitCall();
    }

    @Override
    public void onSuccess(String message, ArrayList<AndroidVersion> data) {

        mGetDataView.onGetDataSuccess(message, data);
    }

    @Override
    public void onFailure(String message) {

        mGetDataView.onGetDataFailure(message);
    }
}