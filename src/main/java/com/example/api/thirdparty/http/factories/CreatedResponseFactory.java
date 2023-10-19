package com.example.api.thirdparty.http.factories;

final class CreatedResponseFactory<T> extends ResponseFactories<T> {
    @Override
    protected String message() {
        return "created";
    }

    @Override
    protected Integer status() {
        return 201;
    }
}
