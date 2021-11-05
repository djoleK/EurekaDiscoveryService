package com.djordje.photoapp.api.users.ui.controllers;

import com.djordje.photoapp.api.users.services.UsersService;
import com.djordje.photoapp.api.users.shared.UsersDto;
import com.djordje.photoapp.api.users.ui.model.CreateUserRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final Environment environment;
    private final UsersService usersService;

    public UsersController(Environment environment, UsersService usersService) {
        this.environment = environment;
        this.usersService = usersService;
    }

    @GetMapping("/status/check")
    public String status() {
        return "Working on port " + environment.getProperty("local.server.port");
    }


    @PostMapping
    public String createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UsersDto usersDto = modelMapper.map(userDetails, UsersDto.class);
        usersService.createUser(usersDto);
        return "Create user method is called";
    }
}
