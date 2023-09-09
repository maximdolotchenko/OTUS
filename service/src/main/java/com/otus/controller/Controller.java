package com.otus.controller;

import com.otus.api.CommonApi;
import com.otus.dto.AppStatusOk;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author MDolotchenko
 */

@RestController
public class Controller implements CommonApi {
    @Override
    public ResponseEntity<AppStatusOk> getStatus() {
        return ResponseEntity.of(Optional.of(AppStatusOk.builder()
                .status("OK")
                .build()));
    }
}
