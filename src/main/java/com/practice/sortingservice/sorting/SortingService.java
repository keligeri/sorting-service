package com.practice.sortingservice.sorting;

import com.practice.sortingservice.dto.RequestPayload;
import com.practice.sortingservice.dto.ResponsePayload;
import com.practice.sortingservice.dto.Request;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SortingService {

    public ResponsePayload sortByKey(Request request) {
        List<String> sortKeys = request.getSortedKeys();
        RequestPayload payload = request.getPayload();
        SortingFacade sortingFacade = new SortingFacade();

        sortingFacade.add("fruits", payload.getFruits());
        sortingFacade.add("colors", payload.getColors());
        sortingFacade.add("numbers", payload.getNumbers());

        sortKeys.forEach(sortingFacade::sortBy);
        return toPayload(sortingFacade.getItems());
    }

    private ResponsePayload toPayload(Map<String, List<? extends Comparable>> items) {
        return new ResponsePayload(
                items.get("fruits"), items.get("numbers"), items.get("colors"));
    }
}
