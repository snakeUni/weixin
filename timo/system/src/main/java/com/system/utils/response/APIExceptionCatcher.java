package com.system.utils.response;

/**
 * Created by Uni on 2017/11/13.
 */
public  abstract class APIExceptionCatcher {
    protected Response handle(Exception ex) {
        return new ErrorResponse(ex.getMessage());
    }
}
