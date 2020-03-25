package com.example.dd.retrofit2.activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dd.retrofit2.fragments.DetailFrag;
import com.example.dd.retrofit2.model.AndroidVersion;
import com.example.dd.retrofit2.adapter.DataAdapter;
import com.example.dd.retrofit2.fragments.ListFrag;
import com.example.dd.retrofit2.R;


public class MainActivity extends AppCompatActivity implements DataAdapter.ItemClicked {

    private DetailFrag frag2;
    private FragmentTransaction fTrans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFrag frag1 = new ListFrag();
        frag2 = new DetailFrag();

        fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.add(R.id.container, frag1);
        fTrans.commit();
    }


    @Override
    public void onItemClicked(AndroidVersion androidVersion) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("data", androidVersion);
        frag2.setArguments(bundle);

        fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.replace(R.id.container, frag2);
        fTrans.addToBackStack(null);
        fTrans.commit();
    }
}