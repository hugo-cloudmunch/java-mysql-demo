package com.cloudmunch.demo;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Created by hugo on 4/24/15.
 */
public class JsonHelper implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}
