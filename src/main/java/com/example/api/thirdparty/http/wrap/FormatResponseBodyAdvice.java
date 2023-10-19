package com.example.api.thirdparty.http.wrap;

import com.example.api.thirdparty.http.JsonResponse;
import com.example.api.thirdparty.http.contacts.Factory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
final public class FormatResponseBodyAdvice<T> implements ResponseBodyAdvice<T> {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Factory<Object> factory;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if (!(body instanceof JsonResponse)) {

            if (returnType.getGenericParameterType().equals(String.class)) {
                try {
                    body = objectMapper.writeValueAsString(this.factory.make(body, request.getMethod().name()));
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }

                return body;
            }

            body = this.factory.make(body, request.getMethod().name());
        }

        return body;
    }
}
