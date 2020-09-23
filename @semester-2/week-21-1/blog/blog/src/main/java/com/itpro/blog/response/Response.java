package com.itpro.blog.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {

    public static ResponseEntity<Object> build(String message) {

        Map<String, Object> responseBody = new HashMap<>();

        responseBody.put("type", "ERROR");
        responseBody.put("message", message);
        responseBody.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }
}
