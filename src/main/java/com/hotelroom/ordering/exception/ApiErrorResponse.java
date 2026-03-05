package com.hotelroom.ordering.exception;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;
import java.util.List;

@Schema(description = "Standardized API error response")
public class ApiErrorResponse {

    @Schema(example = "400")
    private int status;

    @Schema(example = "Validation failed")
    private String message;

    @Schema(example = "/api/orders")
    private String path;

    private List<String> details;

    private OffsetDateTime timestamp;

    public ApiErrorResponse(int status, String message, String path, List<String> details) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.details = details;
        this.timestamp = OffsetDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public List<String> getDetails() {
        return details;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }
}
