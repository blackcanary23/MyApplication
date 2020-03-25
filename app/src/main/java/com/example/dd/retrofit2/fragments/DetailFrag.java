package com.example.dd.retrofit2.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.dd.retrofit2.R;
import com.example.dd.retrofit2.model.AndroidVersion;


public class DetailFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView tv_name = view.findViewById(R.id.tv_name);
        TextView tv_version = view.findViewById(R.id.tv_version);
        TextView tv_api_level = view.findViewById(R.id.tv_api_level);

        Bundle bundle = getArguments();
        assert bundle != null;
        AndroidVersion android = (AndroidVersion) bundle.getSerializable("data");

        assert android != null;
        tv_name.setText(android.getName());
        tv_version.setText(android.getVer());
        tv_api_level.setText(android.getApi());

        return view;
    }
}
