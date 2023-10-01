package com.otus.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author MDolotchenko
 */
@Data
@Builder
public class UserModifiedResponse {
    private String code;
    private String message;
}
