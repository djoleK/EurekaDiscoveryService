package com.djordje.photoapp.api.users.ui.controllers;

import com.djordje.photoapp.api.users.ui.model.CreateUserRequestModel;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final Environment environment;

    public UsersController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/status/check")
    public String status() {
        return "Working on port " + environment.getProperty("local.server.port");
    }


    @PostMapping
    public String createUser(@RequestBody CreateUserRequestModel userDetails) {
        return "Create user method is called";
    }
}
