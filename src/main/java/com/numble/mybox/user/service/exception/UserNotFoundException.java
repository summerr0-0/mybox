package com.numble.mybox.user.service.exception;

import com.numble.mybox.common.exception.ErrorCodeException;

public class UserNotFoundException extends ErrorCodeException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
