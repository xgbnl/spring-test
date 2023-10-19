package com.example.api.thirdparty.http;

public record JsonResponse<T>(Integer code,String message,T data) {
}
