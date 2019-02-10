package com.practice.sortingservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RequestPayload {

    private List<String> fruits;
    private List<Integer> numbers;
    private List<String> colors;
}
