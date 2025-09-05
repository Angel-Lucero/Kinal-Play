package org.kaven.kinal_play.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/Hola")
    public String HolaMundo(){
        return "Hola Mundo estoy en Spring Boot";
    }
}
