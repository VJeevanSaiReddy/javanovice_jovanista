package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MainThree {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> employeeClass = Class.forName("com.reflection.EmployeeConst");

        System.out.println("************** public constructors");

        Constructor<?>[] constructors = employeeClass.getConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();

        // Run till here

        System.out.println("************** public + protected + private constructors");

        constructors = employeeClass.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();

        // Run till here

        System.out.println("************** public + protected + private constructors");

        constructors = employeeClass.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println("--- Constructor + Parameter types");
            System.out.println(constructor);

            Class<?>[] parameters = constructor.getParameterTypes();
            for (Class<?> parameter : parameters) {
                System.out.println(parameter);
            }
        }

        System.out.println();

        // Run till here

        System.out.println("************** No argument constructor");

        Constructor<?> noArgumentConstructor = employeeClass.getConstructor();

        System.out.println(noArgumentConstructor);

        Object object = noArgumentConstructor.newInstance();
        System.out.println("Object: " + object);

        EmployeeConst employee = (EmployeeConst) noArgumentConstructor.newInstance();
        System.out.println("Employee: " + employee);

        System.out.println();

        // Run till here

        System.out.println("************** 3 argument constructor");

        Constructor<?> threeArgumentConstructor = employeeClass.getConstructor(
                String.class, String.class, double.class);

        EmployeeConst dorian = (EmployeeConst) threeArgumentConstructor.newInstance("Dorian", "MD", 89000);
        System.out.println("Dorian: " + dorian);

        System.out.println();

        // Run till here

        System.out.println("************** private constructor");

        Constructor<?> privateConstructor = employeeClass.getDeclaredConstructor(String.class);

//        Employee nancy = (Employee) privateConstructor.newInstance("Nancy");
//        System.out.println("Nancy: " + nancy);
//
//        System.out.println();

        // Run till here, the previous bit of code will throw an exception
        // Show the exception, comment out the code and then continue

        privateConstructor.setAccessible(true);

        EmployeeConst nancy = (EmployeeConst) privateConstructor.newInstance("Nancy");
        System.out.println("Nancy: " + nancy);

        System.out.println();

        // Run till here

//        Employee julian = (Employee) threeArgumentConstructor.newInstance("Julian", "MD");

        // Run till here, the previous line will be an error

//        getdeclared(Field,Constructor) vs get(Field,Constructor)
    }
}