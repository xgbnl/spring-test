package com.example.api.thirdparty.http.factories;

public final class NoContentResponseFactory<T> extends ResponseFactories<T> {
    @Override
    protected String message() {
        return "noContent";
    }

    @Override
    protected Integer status() {
        return 204;
    }
}
