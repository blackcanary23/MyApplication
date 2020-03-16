package com.example.dd.retrofit2.activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.dd.retrofit2.model.AndroidVersion;
import com.example.dd.retrofit2.adapter.DataAdapter;
import com.example.dd.retrofit2.fragments.ListFrag;
import com.example.dd.retrofit2.R;


public class MainActivity extends AppCompatActivity implements DataAdapter.ItemClicked {

    ListFrag listFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = this.getSupportFragmentManager();
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.listFrag);

    }



    @Override
    public void onItemClicked(AndroidVersion androidVersion) {

        startActivity(new Intent(MainActivity.this, DisplayActivity.class).putExtra("data", androidVersion));


    }
}