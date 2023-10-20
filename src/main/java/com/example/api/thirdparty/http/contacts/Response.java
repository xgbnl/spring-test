package com.example.api.thirdparty.http.contacts;

public interface Response {
    String message();

    Integer code();

    interface Factory<T> {

        JsonResponse<T> make(final T data, final String method);

        record JsonResponse<T>(Integer code, String message, T data) {
        }
    }
}
