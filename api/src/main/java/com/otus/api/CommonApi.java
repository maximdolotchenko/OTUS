package com.otus.api;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.otus.dto.AppStatusOk;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author MDolotchenko
 */
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public interface CommonApi {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    ResponseEntity<AppStatusOk> getStatus();
}
