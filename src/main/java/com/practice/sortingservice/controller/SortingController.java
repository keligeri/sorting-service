package com.practice.sortingservice.controller;

import com.practice.sortingservice.dto.Request;
import com.practice.sortingservice.dto.ResponsePayload;
import com.practice.sortingservice.sorting.SortingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api("Sorting controller")
@RestController
@RequiredArgsConstructor
public class SortingController {

    private final SortingService sortingService;

    @PostMapping("/sort")
    @ApiOperation(value = "Sort payload by sorted-keys", response = ResponsePayload.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sorted list by sortedKeys property"),
            @ApiResponse(code = 400, message = "Not supported sorted-key")
        }
    )
    public ResponsePayload sortByKeys(@Valid @RequestBody Request request) {
        return sortingService.sortByKeys(request);
    }
}
