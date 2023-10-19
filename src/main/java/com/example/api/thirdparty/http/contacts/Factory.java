package com.example.api.thirdparty.http.contacts;

import com.example.api.thirdparty.http.JsonResponse;

public interface Factory<T> {
    JsonResponse<T> make(final T data, final String method);
}
