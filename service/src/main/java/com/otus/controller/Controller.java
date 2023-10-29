package com.otus.controller;

import com.otus.api.CommonApi;
import com.otus.dto.AppStatusOk;
import com.otus.dto.UserDto;
import com.otus.service.impl.UserServiceImpl;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

/**
 * @author MDolotchenko
 */

@RestController
@RequiredArgsConstructor
@Slf4j
public class Controller implements CommonApi {

    private final UserServiceImpl userService;

    @Override
    @Counted(value = "get_status")
    @Timed(value = "get_status", percentiles = {0.5, 0.95, 0.99, 0.999})
    public ResponseEntity<AppStatusOk> getStatus() {
        return ResponseEntity.of(Optional.of(AppStatusOk.builder()
                .status("OK")
                .build()));
    }

    @Override
    @Counted(value = "create_user")
    @Timed(value = "create_user", percentiles = {0.5, 0.95, 0.99, 0.999})
    public ResponseEntity<Void> createUser(UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok().build();
    }

    @Override
    @Counted(value = "get_user")
    @Timed(value = "get_user", percentiles = {0.5, 0.95, 0.99, 0.999})
    public ResponseEntity<UserDto> getUser(Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @Override
    @Counted("delete_user")
    @Timed(value = "delete_user", percentiles = {0.5, 0.95, 0.99, 0.999})
    public ResponseEntity<Void> deleteUser(Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    @Counted(value = "update_user")
    @Timed(value = "update_user", percentiles = {0.5, 0.95, 0.99, 0.999})
    public ResponseEntity<UserDto> updateUser(Long userId, UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(userId, userDto));
    }

    @Override
    @Counted(value = "return500")
    @Timed(value = "return500", percentiles = {0.5, 0.95, 0.99, 0.999})
    public ResponseEntity<Void> return500() {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(3000 - 1000) + 1000);
            var dateTimeNow = LocalDateTime.now();
            if ((dateTimeNow.getMinute() + 1) / 2 == 0 && (dateTimeNow.getSecond() <= 20)) {
                return ResponseEntity.internalServerError().build();
            }
        } catch (InterruptedException e) {
            log.warn("InterruptedException was thrown");
        }
        return ResponseEntity.ok().build();
    }
}
