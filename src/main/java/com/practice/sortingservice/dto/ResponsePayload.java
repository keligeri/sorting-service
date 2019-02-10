package com.practice.sortingservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class ResponsePayload {

    private List<? extends Comparable> fruits;
    private List<? extends Comparable> numbers;
    private List<? extends Comparable> colors;

    public ResponsePayload(
            List<? extends Comparable> fruits,
            List<? extends Comparable> numbers,
            List<? extends Comparable> colors) {

        this.fruits = fruits;
        this.numbers = numbers;
        this.colors = colors;
    }
}
