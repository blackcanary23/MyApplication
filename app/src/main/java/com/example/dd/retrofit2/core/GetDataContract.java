package com.example.dd.retrofit2.core;

import android.content.Context;
import com.example.dd.retrofit2.model.AndroidVersion;
import java.util.ArrayList;


public interface GetDataContract {
    interface View{
        void onGetDataSuccess(String message, ArrayList<AndroidVersion> list);
        void onGetDataFailure(String message);
    }
    interface Presenter{
        void getDataFromURL(Context context, String url);
    }
    interface Interactor{
        void initRetrofitCall(Context context, String url);

    }
    interface onGetDataListener{
        void onSuccess(String message, ArrayList<AndroidVersion> list);
        void onFailure(String message);
    }
}