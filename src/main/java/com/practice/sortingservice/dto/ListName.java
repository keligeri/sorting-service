package com.practice.sortingservice.dto;

public enum ListName {
    FRUITS("fruits"), COLORS("colors"), NUMBERS("numbers");

    private String name;

    ListName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
