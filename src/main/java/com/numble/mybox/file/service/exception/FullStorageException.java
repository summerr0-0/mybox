package com.numble.mybox.file.service.exception;

import com.numble.mybox.common.exception.ErrorCodeException;

public class FullStorageException extends ErrorCodeException {
    public FullStorageException() {
        super(ErrorCode.STORAGE_IS_FULL);
    }
}
