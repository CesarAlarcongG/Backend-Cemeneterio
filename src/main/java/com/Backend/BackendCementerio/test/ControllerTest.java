package com.Backend.BackendCementerio.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ControllerTest {
    @GetMapping("/get")
    public String getPublico() {
        return "Este es un endpoint público";
    }

    @GetMapping("/getP")
    public String getPrivado() {
        return "Este es un endpoint privado";
    }

    @PostMapping("/post")
    public String postPublico() {
        return "Este es un endpoint público";
    }

    @PostMapping("/postP")
    public String postPrivado() {
        return "Este es un endpoint privado";
    }
}

