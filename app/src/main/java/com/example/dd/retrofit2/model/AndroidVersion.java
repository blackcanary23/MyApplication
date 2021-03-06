package com.example.dd.retrofit2.model;

import java.io.Serializable;


public class AndroidVersion implements Serializable {

    private String ver;
    private String name;
    private String api;

    public AndroidVersion(String ver, String name, String api) {

        this.ver = ver;
        this.name = name;
        this.api = api;
    }

    public String getVer() {

        return ver;
    }


    public String getName() {

        return name;
    }


    public String getApi() {

        return api;
    }
}