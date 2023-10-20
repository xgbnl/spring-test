package com.example.api.thirdparty.http;

import com.example.api.thirdparty.http.contacts.Response;
import com.example.api.thirdparty.http.exception.JsonResponseConverterException;
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

        if (!(body instanceof Response.Factory.JsonResponse<?>)) {

            if (returnType.getGenericParameterType().equals(String.class)) {
                try {
                    body = objectMapper.writeValueAsString(this.factory.make(body, request.getMethod().name()));
                } catch (JsonProcessingException e) {
                    throw new JsonResponseConverterException(e);
                }

                return body;
            }

            body = this.factory.make(body, request.getMethod().name());
        }

        return body;
    }
}
