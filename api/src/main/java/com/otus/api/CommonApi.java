package com.otus.api;

import com.otus.dto.AppStatusOk;
import com.otus.dto.UserDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
}
