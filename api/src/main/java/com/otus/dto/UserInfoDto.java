package com.otus.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * @author MDolotchenko
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoDto {
    private String userId;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private String avatarUri;
    private String age;
}
