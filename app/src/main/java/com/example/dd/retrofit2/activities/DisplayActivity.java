package com.example.dd.retrofit2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.dd.retrofit2.model.AndroidVersion;
import com.example.dd.retrofit2.R;


public class DisplayActivity extends AppCompatActivity  {

    TextView tv_name, tv_version, tv_api_level;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.fragment_detail);

        tv_name = findViewById(R.id.tv_name);
        tv_version = findViewById(R.id.tv_version);
        tv_api_level = findViewById(R.id.tv_api_level);

        Intent intent = getIntent();

        if (intent.getExtras() != null){

            AndroidVersion androidVersion = (AndroidVersion) intent.getSerializableExtra("data");

            tv_name.setText(androidVersion.getName());
            tv_version.setText(androidVersion.getVer());
            tv_api_level.setText(androidVersion.getApi());

        }

    }
}
