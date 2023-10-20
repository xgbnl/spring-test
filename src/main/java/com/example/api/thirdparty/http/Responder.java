package com.example.api.thirdparty.http;

import com.example.api.thirdparty.http.contacts.Response;
import org.springframework.stereotype.Component;

@Component
final public class Responder<T> implements Response.Factory<T> {

    @Override
    public Response.Factory.JsonResponse<T> make(final T data,final String method) {

        Response response = this.makeResponder(method);

        return (data instanceof String)
                ? new JsonResponse<>(response.code(), (String)data, null)
                : new JsonResponse<>(response.code(), response.message(), data);
    }

    private Response makeResponder(final String method) {
        return switch (method) {
            case "POST", "PATCH" -> this.anonymousResponse("created", 201);
            case "DELETE" -> this.anonymousResponse("noContent", 204);
            default -> this.anonymousResponse("success", 200);
        };
    }
    private Response anonymousResponse(final String message, final Integer code) {
        return new Response() {
            @Override
            public String message() {
                return message;
            }

            @Override
            public Integer code() {
                return code;
            }
        };
    }

}
