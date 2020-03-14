package com.example.dd.retrofit2;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements DataAdapter.ItemClicked {

    ListFrag listFrag;
    FragmentManager fragmentManager;
    TextView tv_name, tv_version, tv_api_level;
    ArrayList<AndroidVersion> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv_name = findViewById(R.id.tv_name);
        tv_version = findViewById(R.id.tv_version);
        tv_api_level = findViewById(R.id.tv_api_level);


        fragmentManager = this.getSupportFragmentManager();
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.listFrag);

    }


    @Override
    public void onItemClicked(AndroidVersion androidVersion) {

        startActivity(new Intent(MainActivity.this, DisplayActivity.class).putExtra("data", androidVersion));


    }
}