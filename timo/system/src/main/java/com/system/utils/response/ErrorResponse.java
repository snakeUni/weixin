package com.system.utils.response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Uni on 2017/11/13.
 */
public class ErrorResponse extends Response {

    private Map<String, Object> error_response = new HashMap<String, Object>();

    public ErrorResponse(){
        error_response.put("code", "-1");
        error_response.put("message", "未知错误");
    }

    public ErrorResponse(String erroCode, String message) {
        error_response.put("code", erroCode);
        error_response.put("message", message);
    }

    public ErrorResponse(String message) {
        error_response.put("code", "-1");
        error_response.put("message", message);
    }

    public ErrorResponse(Exception ex){
        error_response.put("code", ex.getMessage());
        error_response.put("message", ex.getMessage());
    }
}
