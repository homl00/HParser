package com.hparser.hparser.enums;

public enum DefaultSheetName {
    NAME("ParsedData");

    private final String name;

    DefaultSheetName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
