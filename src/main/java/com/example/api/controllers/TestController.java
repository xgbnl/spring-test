package com.example.api.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
final public class TestController extends Controller {

    @GetMapping("/tests")
    public Map<String, Object> index() {

        Map<String,Object> map = new HashMap<>();

        map.put("name","jack");
        map.put("phone","123456");

        return map;
    }

    @PostMapping("/tests")
    public Map<String, Object> store() {
        Map<String,Object> map = new HashMap<>();

        map.put("name","jack");
        map.put("phone","123456");

        return map;
    }
}
