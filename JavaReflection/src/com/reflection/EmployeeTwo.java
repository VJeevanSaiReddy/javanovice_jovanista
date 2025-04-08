package com.reflection;

import java.util.Random;

public class EmployeeTwo {

    private static final Random employeeIdGenerator = new Random();

    private int employeeId;

    public EmployeeTwo() {
        this.employeeId = Math.abs(employeeIdGenerator.nextInt());
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}

