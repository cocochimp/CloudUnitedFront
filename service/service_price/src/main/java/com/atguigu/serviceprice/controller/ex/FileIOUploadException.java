package com.atguigu.serviceprice.controller.ex;

/** 上传文件时读写异常 */
public class FileIOUploadException extends FileUploadException {
    public FileIOUploadException() {
        super();
    }

    public FileIOUploadException(String message) {
        super(message);
    }

    public FileIOUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileIOUploadException(Throwable cause) {
        super(cause);
    }

    protected FileIOUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
