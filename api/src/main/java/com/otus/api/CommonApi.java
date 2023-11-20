package com.otus.api;

import com.otus.dto.AppStatusOk;
import com.otus.dto.UserDto;
import com.otus.dto.UserInfoDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MDolotchenko
 */
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public interface CommonApi {

    @GetMapping(value = "/health")
    ResponseEntity<AppStatusOk> getStatus();

    @PostMapping(value = "/user")
    ResponseEntity<Void> createUser(@RequestBody UserDto userDto);

    @GetMapping(value = "/user/{userId}")
    ResponseEntity<UserDto> getUser(@PathVariable Long userId);

    @DeleteMapping(value = "/user/{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable Long userId);

    @PutMapping(value = "/user/{userId}")
    ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UserDto userDto);

    @GetMapping(value = "/internal-error")
    ResponseEntity<Void> return500();

    @GetMapping(value = "/users/me")
    ResponseEntity<UserInfoDto> me(
            @RequestHeader(value = "X-User-Id") String userId,
            @RequestHeader(value = "X-User", required = false) String login,
            @RequestHeader(value = "X-Email", required = false) String email,
            @RequestHeader(value = "X-First-Name", required = false) String firstName,
            @RequestHeader(value = "X-Last-Name", required = false) String lastName
    );

    @PutMapping(value = "/users/me")
    ResponseEntity<UserInfoDto> updateMe(
            @RequestHeader(value = "X-User-Id") String userId,
            @RequestHeader(value = "X-User", required = false) String login,
            @RequestHeader(value = "X-Email", required = false) String email,
            @RequestHeader(value = "X-First-Name", required = false) String firstName,
            @RequestHeader(value = "X-Last-Name", required = false) String lastName,
            @RequestBody UserInfoDto userInfoDto
    );
}
