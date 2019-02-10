package com.practice.sortingservice.sorting;

import com.practice.sortingservice.configuration.SortingName;
import com.practice.sortingservice.dto.RequestPayload;
import com.practice.sortingservice.dto.ResponsePayload;
import com.practice.sortingservice.dto.Request;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SortingService {

    private final SortingName validNames;

    public ResponsePayload sortByKey(Request request) {
        List<String> sortKeys = request.getSortedKeys();

        SortingFacade sortingFacade = populate(request.getPayload());
        sortKeys.forEach(sortingFacade::sortBy);

        return toPayload(sortingFacade.getItems());
    }

    private SortingFacade populate(RequestPayload payload) {
        SortingFacade sortingFacade = new SortingFacade();
        sortingFacade.add(validNames.getFruits(), payload.getFruits());
        sortingFacade.add(validNames.getColors(), payload.getColors());
        sortingFacade.add(validNames.getNumbers(), payload.getNumbers());

        return sortingFacade;
    }

    private ResponsePayload toPayload(Map<String, List<? extends Comparable>> items) {
        return new ResponsePayload(
                items.get(validNames.getFruits()), items.get(validNames.getNumbers()),
                items.get(validNames.getColors()));
    }
}
