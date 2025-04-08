package com.generics;

public class Car {
    public String Make;
    public String Model;
    public Integer Year;

    public Car(String Make,String Model,Integer Year) {
        this.Make = Make;
        this.Model = Model;
        this.Year = Year;
    }
    public String toString() {
        return String.format("Make: %s, Model: %s, Year: %s", Make, Model, Year);
    }
}
