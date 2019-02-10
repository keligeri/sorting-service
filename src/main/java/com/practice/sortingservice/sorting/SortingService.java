package com.practice.sortingservice.sorting;

import com.practice.sortingservice.configuration.SupportedListName;
import com.practice.sortingservice.dto.Request;
import com.practice.sortingservice.dto.RequestPayload;
import com.practice.sortingservice.dto.ResponsePayload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SortingService {

    private final SupportedListName validNames;

    public ResponsePayload sortByKeys(Request request) {
        List<String> sortKeys = request.getSortedKeys();

        SortingFacade sortingFacade = populateFacade(request.getPayload());
        sortKeys.forEach(sortingFacade::sortBy);

        return toPayload(sortingFacade);
    }

    private SortingFacade populateFacade(RequestPayload payload) {
        SortingFacade sortingFacade = new SortingFacade();
        sortingFacade.add(validNames.getFruits(), payload.getFruits());
        sortingFacade.add(validNames.getColors(), payload.getColors());
        sortingFacade.add(validNames.getNumbers(), payload.getNumbers());

        return sortingFacade;
    }

    private ResponsePayload toPayload(SortingFacade sortingFacade) {
        return new ResponsePayload(
                sortingFacade.getBy(validNames.getFruits()),
                sortingFacade.getBy(validNames.getNumbers()),
                sortingFacade.getBy(validNames.getColors()));
    }
}
