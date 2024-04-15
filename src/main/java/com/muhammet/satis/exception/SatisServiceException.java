package com.muhammet.satis.exception;

import lombok.Getter;

@Getter
public class SatisServiceException extends RuntimeException{

    private final ErrorType errorType;
    public SatisServiceException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public SatisServiceException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
