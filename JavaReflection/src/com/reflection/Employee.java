package com.reflection;
import java.util.*;
public class Employee {
    public static final String ORGANIZATION = "Organization";
    private static final Random employeeIdGenerator = new Random();
    private String name;
    private int employeeId;
    private String title;
    private double salary;
    public Employee() {
        this.employeeId = Math.abs(employeeIdGenerator.nextInt());
    }
    public Employee(String name, String title, double salary) {
        this();
        this.name = name;
        this.title = title;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    private double computeBonusInternal(float BonusPercentage) {
        return BonusPercentage * this.salary;
    }
    private double computeTotalSalary(float BonusPercentage) {
        return computeBonusInternal(BonusPercentage) * salary;
    }
    public String toString() {
        return String.format("Id:%d name: %s  title: %s salary: %f  ",employeeId,name,title,salary);
    }
}
