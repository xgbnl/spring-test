package com.example.api.app.http.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
final public class TalentSquareController {

    @GetMapping("/merchant/square")
    public void index(){
        System.out.println(" ");
    }

}
