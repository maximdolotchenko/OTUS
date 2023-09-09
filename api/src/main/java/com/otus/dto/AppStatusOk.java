package com.otus.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author MDolotchenko
 */
@Data
@Builder
public class AppStatusOk {
    private String status;
}
