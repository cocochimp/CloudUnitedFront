package com.atguigu.servicelunbotu.exception;

public class AllException extends RuntimeException{
    private AllEnum anAllEnum;

    public AllException(AllEnum anAllEnum) {
        super(anAllEnum.getMessage());
        this.anAllEnum = anAllEnum;
    }
}
