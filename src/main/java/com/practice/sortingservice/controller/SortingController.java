package com.practice.sortingservice.controller;

import com.practice.sortingservice.dto.ResponsePayload;
import com.practice.sortingservice.dto.Request;
import com.practice.sortingservice.sorting.SortingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SortingController {

    private final SortingService sortingService;

    @PostMapping("/sort")
    public ResponsePayload sortByKey(@RequestBody Request request) {
        return sortingService.sortByKey(request);
    }
}
