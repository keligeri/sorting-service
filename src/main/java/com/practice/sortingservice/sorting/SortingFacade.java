package com.practice.sortingservice.sorting;

import com.practice.sortingservice.exception.NoSuchKeyException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortingFacade {

    private Map<String, List<? extends Comparable>> items;

    public SortingFacade() {
        this.items  = new HashMap<>();
    }

    public void add(String key, List<? extends Comparable> item) {
        items.put(key, item);
    }

    public void sortBy(String key) {
        validateKey(key);
        items.get(key).sort(Comparator.naturalOrder());
    }

    public List<? extends Comparable> getBy(String key) {
        validateKey(key);
        return items.get(key);
    }

    private void validateKey(String key) {
        if (!items.containsKey(key)) {
            String msg = String.format("Cannot find list with key: %s", key);
            throw new NoSuchKeyException(msg);
        }
    }
}
