package com.otus.service.impl;

import com.otus.dto.UserDto;
import com.otus.entities.UserEntity;
import com.otus.service.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author MDolotchenko
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;

    public void createUser(UserDto userDto) {

        userRepository.save(UserEntity.builder()
                .lastName(userDto.getLastName())
                .firstName(userDto.getFirstName())
                .email(userDto.getEmail())
                .build()
        );
    }

    public UserDto getUser(Long userId) {
        return userRepository.findById(userId).
                map(userEntity -> UserDto.builder()
                        .lastName(userEntity.getLastName())
                        .firstName(userEntity.getFirstName())
                        .email(userEntity.getEmail())
                        .build()).orElse(null);

    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

    }

    public UserDto updateUser(Long userId, UserDto userDto) {
        var userEntity = userRepository.findById(userId).orElseThrow();
        if (Objects.nonNull(userDto.getFirstName()))
            userEntity.setFirstName(userDto.getFirstName());
        if (Objects.nonNull(userDto.getLastName()))
            userEntity.setLastName(userDto.getLastName());
        if (Objects.nonNull(userDto.getEmail()))
            userEntity.setEmail(userDto.getEmail());
        var updatedEntity = userRepository.save(userEntity);
        return UserDto.builder()
                .firstName(updatedEntity.getFirstName())
                .lastName(updatedEntity.getLastName())
                .email(updatedEntity.getEmail())
                .build();
    }
}
