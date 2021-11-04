package com.djordje.photoapp.api.users.services;

import com.djordje.photoapp.api.users.shared.UsersDto;

public interface UsersService {
    UsersDto createUser(UsersDto userDetails);
}
