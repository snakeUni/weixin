package com.timo.mini.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Uni on 2018/1/15.
 */
public class Response implements Serializable{

    private Map<String, Object> get_response = new HashMap<String, Object>();

    public Response(String key, Object value) {
        get_response.put(key, value);
    }
}
