package br.com.auth_API.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome() {
        return "Welcome to the home page!";
    }

    @GetMapping("/users")
    public String users() {
        return "Authorized. Welcome to the users page!";
    }

    @GetMapping("/managers")
    public String managers() {
        return "Authorized. Welcome to the managers page!";
    }

}
