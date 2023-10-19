package com.example.api.thirdparty.http.factories;

final public class SuccessResponseFactory<T> extends ResponseFactories<T> {

    @Override
    protected String message() {
        return "success";
    }

    @Override
    protected Integer status() {
        return 200;
    }
}
