package com.example.api.provider.response.exception;

final public class JsonResponseConverterException extends RuntimeException {

    public JsonResponseConverterException(Throwable throwable) {
        super(throwable);
    }
}
