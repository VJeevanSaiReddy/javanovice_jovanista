package com.generics;

public class Repository<T>{
    public T value;
    public Repository(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public String toString() {
        return String.format("value: %s", value);
    }
}

