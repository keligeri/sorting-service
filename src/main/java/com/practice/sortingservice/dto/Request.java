package com.practice.sortingservice.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Request {

    private List<String> sortedKeys;

    @NotNull(message = "Request payload cannot be empty")
    private RequestPayload payload;
}
