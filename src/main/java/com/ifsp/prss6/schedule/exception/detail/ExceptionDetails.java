package com.ifsp.prss6.schedule.exception.detail;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author vinicius.montouro
 */
@Data
@Builder
public class ExceptionDetails {
    private String title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDateTime timestamp;
}
