package com.atguigu.serviceprice.service.ex;

public class PageSelectException extends ServiceException{
    public PageSelectException() {
        super();
    }

    public PageSelectException(String message) {
        super(message);
    }

    public PageSelectException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageSelectException(Throwable cause) {
        super(cause);
    }

    protected PageSelectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
