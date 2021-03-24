package com.example.demo.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseController {

    protected Gson gson;

    public BaseController() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder
                .excludeFieldsWithoutExposeAnnotation()
                .serializeSpecialFloatingPointValues()
                .serializeNulls()
                .create();
    }
}
