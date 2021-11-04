package com.djordje.photoapp.api.users.services.impl;

import com.djordje.photoapp.api.users.services.UsersService;
import com.djordje.photoapp.api.users.shared.UsersDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {
    @Override
    public UsersDto createUser(UsersDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        return null;
    }
}
