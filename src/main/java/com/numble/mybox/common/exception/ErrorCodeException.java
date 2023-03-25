package com.numble.mybox.common.exception;

public abstract class ErrorCodeException extends RuntimeException {
    private final ErrorCode errorCode;

    public ErrorCodeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCodeException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCodeException(ErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public String getKey() {
        return errorCode.getKey();
    }

    public String getMessage() {
        return errorCode.getMessage();
    }

    protected enum ErrorCode {
        USER_NOT_FOUND("사용자 정보가 존재하지 않습니다."),
        STORAGE_IS_FULL("사용가능한 용량이 초과되었습니다"),
        USER_ALREADY_EXIST("이미 존재하는 유저아이디입니다"),
        FILE_NOT_FOUND("해당 파일을 찾을 수 없습니다");
        private final String message;

        ErrorCode(String message) {
            this.message = message;
        }

        public String getKey() {
            return name().replace("_", "-").toLowerCase();
        }

        public String getMessage() {
            return message;
        }
    }
}