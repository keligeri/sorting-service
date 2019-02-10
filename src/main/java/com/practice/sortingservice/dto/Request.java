package com.practice.sortingservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class Request {

    private List<String> sortedKeys;
    private RequestPayload payload;
}
