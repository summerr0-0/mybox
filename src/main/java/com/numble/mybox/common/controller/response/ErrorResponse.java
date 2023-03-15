package com.numble.mybox.common.controller.response;

import com.numble.mybox.common.exception.ErrorCodeException;

public class ErrorResponse {
    private final Meta meta;

    public ErrorResponse(String errorCode, String errorMessage) {
        this.meta = new Meta.Fail(errorCode, errorMessage);
    }

    public ErrorResponse(ErrorCodeException e) {
        this(
            e.getKey(),
            e.getMessage()
        );
    }
}
