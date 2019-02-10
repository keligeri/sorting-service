package com.practice.sortingservice.sorting;

import com.practice.sortingservice.exception.NoSuchKeyException;
import lombok.Getter;

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
        items.get(key).sort(Comparator.naturalOrder());
    }

    public List<? extends Comparable> getBy(String key) {
        if (items.containsKey(key)) {
            return items.get(key);
        }

        throw new NoSuchKeyException("Cannot find list with key: " + key);
    }
}
