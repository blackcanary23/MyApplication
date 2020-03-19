package com.example.dd.retrofit2.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.dd.retrofit2.core.GetDataContract;
import com.example.dd.retrofit2.core.Presenter;
import com.example.dd.retrofit2.model.AndroidVersion;
import com.example.dd.retrofit2.adapter.DataAdapter;
import com.example.dd.retrofit2.R;
import java.util.ArrayList;


public class ListFrag extends Fragment implements GetDataContract.View {

    private RecyclerView recyclerView;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        Presenter mPresenter = new Presenter(this);
        mPresenter.getDataFromURL(this.getActivity());

        recyclerView = view.findViewById(R.id.list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

    }


    @Override
    public void onGetDataSuccess(String message,  ArrayList<AndroidVersion> data) {

        RecyclerView.Adapter myAdapter = new DataAdapter(getActivity(), data);
        recyclerView.setAdapter(myAdapter);

    }

    @Override
    public void onGetDataFailure(String message) {

        Log.d("Status",message);
    }

}





