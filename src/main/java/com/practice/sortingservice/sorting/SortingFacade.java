package com.practice.sortingservice.sorting;

import lombok.Getter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
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
}
