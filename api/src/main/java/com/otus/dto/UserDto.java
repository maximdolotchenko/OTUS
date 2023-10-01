package com.otus.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author MDolotchenko
 */
@Data
@Builder
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
}
