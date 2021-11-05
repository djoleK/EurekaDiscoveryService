package com.djordje.photoapp.api.users.services.impl;

import com.djordje.photoapp.api.users.data.UserEntity;
import com.djordje.photoapp.api.users.data.UserRepository;
import com.djordje.photoapp.api.users.services.UsersService;
import com.djordje.photoapp.api.users.shared.UsersDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UsersServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UsersDto createUser(UsersDto userDetails) {

        userDetails.setUserId(UUID.randomUUID().toString());
        userDetails.setEncryptedPassword(encoder.encode(userDetails.getPassword()));
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);

        userRepository.save(userEntity);

        UsersDto returnValue = modelMapper.map(userEntity, UsersDto.class);
        return userDetails;
    }
}
