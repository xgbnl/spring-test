package com.example.api.thirdparty.http.factories;

import com.example.api.thirdparty.http.JsonResponse;
import com.example.api.thirdparty.http.contacts.Factory;

sealed abstract class ResponseFactories<T> implements Factory<T>
        permits SuccessResponseFactory, CreatedResponseFactory, NoContentResponseFactory {
    final public JsonResponse<T> make(final T data, final String method) {
        return data instanceof String
                ? this.makeResponse(null, (String) data)
                : this.makeResponse(data, this.message());
    }

    abstract protected String message();

    private JsonResponse<T> makeResponse(final T data, final String message) {
        return new JsonResponse<>(this.status(), message, data);
    }

    abstract protected Integer status();
}
