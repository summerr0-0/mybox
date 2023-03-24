package com.numble.mybox.user.service.exception;

import com.numble.mybox.common.exception.ErrorCodeException;

public class UserAlreadyExistException extends ErrorCodeException {
    public UserAlreadyExistException() {
        super(ErrorCode.USER_ALREADY_EXIST);
    }
}
