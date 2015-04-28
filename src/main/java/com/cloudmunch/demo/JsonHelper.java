package com.cloudmunch.demo;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * JsonHelper.
 * Created by hugo on 4/24/15.
 */
public class JsonHelper implements ResponseTransformer {

    /**
     * gson.
     */
    private Gson gson = new Gson();

    /**
     * render.
     * @param model This is the model
     * @return JSON string
     */
    @Override
    public final String render(final Object model) {
        return gson.toJson(model);
    }

}
