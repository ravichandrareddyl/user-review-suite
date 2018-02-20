package com.userreview.exception;

public class BusinessException extends Exception{

    private static final long serialVersionUID = 1823999520161348000L;
    public BusinessException(String message) {
        super(message);
    }

}