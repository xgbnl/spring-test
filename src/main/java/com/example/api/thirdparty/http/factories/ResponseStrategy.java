package com.example.api.thirdparty.http.factories;

import com.example.api.thirdparty.http.JsonResponse;
import com.example.api.thirdparty.http.contacts.Factory;
import org.springframework.stereotype.Component;

@Component
public class ResponseStrategy<T> implements Factory<T> {

    @Override
    public JsonResponse<T> make(final T data, final String method) {
        return this.strategy(method).make(data, method);
    }

    private ResponseFactories<T> strategy(String method) {
        return switch (method) {
            case "POST", "PATCH" -> new CreatedResponseFactory<>();
            case "DELETE" -> new NoContentResponseFactory<>();
            default -> new SuccessResponseFactory<>();
        };
    }
}
