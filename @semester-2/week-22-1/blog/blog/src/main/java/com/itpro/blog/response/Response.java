package com.itpro.blog.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Response {

    public static ResponseEntity<Object> error(String message) {

        Map<String, Object> responseBody = new HashMap<>();

        responseBody.put("type", "ERROR");
        responseBody.put("message", message);
        responseBody.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<Object> success(Object body) {

        Map<String, Object> responseBody = new HashMap<>();

        responseBody.put("type", "SUCCESS");
        responseBody.put("data", body);
        responseBody.put("status", HttpStatus.OK.value());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    public static ResponseEntity<Object> success(Object body, String message) {

        Map<String, Object> responseBody = new HashMap<>();

        responseBody.put("type", "SUCCESS");
        responseBody.put("data", body);
        responseBody.put("message", message);
        responseBody.put("status", HttpStatus.OK.value());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}
