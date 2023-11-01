package com.example.api.provider.response;

import com.example.api.provider.response.contacts.Response;
import com.example.api.provider.response.exception.JsonResponseConverterException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
final public class FormatResponseBodyAdvice<T> implements ResponseBodyAdvice<T> {

    private final ObjectMapper objectMapper;

    private final Response.Factory<Object> factory;

    public FormatResponseBodyAdvice(ObjectMapper objectMapper, Response.Factory<Object> factory) {
        this.objectMapper = objectMapper;
        this.factory = factory;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if (this.isNotJsonResponse(body)) {

            if (returnType.getGenericParameterType().equals(String.class)) {
                return this.convertStringToJsonResponse(body, request);
            }

            body = this.factory.make(body, request.getMethod().name());
        }

        return body;
    }

    private boolean isNotJsonResponse(Object body) {
        return !(body instanceof Response.Factory.JsonResponse<?>);
    }

    private Object convertStringToJsonResponse(Object body, ServerHttpRequest request) {

        try {
            body = objectMapper.writeValueAsString(this.factory.make(body, request.getMethod().name()));
        } catch (JsonProcessingException e) {
            throw new JsonResponseConverterException(e);
        }

        return body;
    }
}