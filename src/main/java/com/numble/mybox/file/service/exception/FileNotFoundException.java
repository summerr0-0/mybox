package com.numble.mybox.file.service.exception;

import com.numble.mybox.common.exception.ErrorCodeException;

public class FileNotFoundException extends ErrorCodeException {
    public FileNotFoundException() {
        super(ErrorCode.FILE_NOT_FOUND);
    }
}
