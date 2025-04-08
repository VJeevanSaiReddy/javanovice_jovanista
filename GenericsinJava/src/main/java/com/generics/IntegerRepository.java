package com.generics;

public class IntegerRepository {
    private Integer value;
    public IntegerRepository(Integer value) {
        this.value = value;
    }
    public Integer getValue() {
        return value;
    }
    public String toString() {
        return String.format("value: %d", value);
    }
}
