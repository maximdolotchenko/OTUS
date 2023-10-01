package com.otus.controller;

import com.otus.api.CommonApi;
import com.otus.dto.AppStatusOk;
import com.otus.dto.UserDto;
import com.otus.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author MDolotchenko
 */

@RestController
@RequiredArgsConstructor
public class Controller implements CommonApi {

    private final UserServiceImpl userService;

    @Override
    public ResponseEntity<AppStatusOk> getStatus() {
        return ResponseEntity.of(Optional.of(AppStatusOk.builder()
                .status("OK")
                .build()));
    }

    @Override
    public ResponseEntity<Void> createUser(UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserDto> getUser(Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDto> updateUser(Long userId, UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(userId, userDto));
    }
}
