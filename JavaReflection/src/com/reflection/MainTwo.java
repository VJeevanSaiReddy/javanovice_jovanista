package com.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class MainTwo {
    private static class HR extends Department {

        public HR() {
            super("HR");
        }
    }
    enum Weekday {
        Monday,
        Tuesday,
        Wednesday,
        Thursday,
        Friday
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

//            Organization organization = new Organization();
//            EmployeeTwo employee = new EmployeeTwo();
//            HR hr = new HR();
//
//            // NOTE: The Department class is abstract and so cannot be instantiated
//
//            Class<?> organizationClass = organization.getClass();
//            Class<?> employeeClass = employee.getClass();
//            Class<?> hrClass = hr.getClass();
//            Class<?> departmentClass = Department.class;
//
//            System.out.println("******* toString() representations of class objects");
//            System.out.println("Organization: " + organizationClass);
//            System.out.println("Employee: " + employeeClass);
//            System.out.println("HR: " + hrClass);
//            System.out.println("Department: " + departmentClass);
//
//            System.out.println();
//
//            // Run till here
//
//            // NOTE: This gives us the fully qualified name of the class
//            System.out.println("******* fully-qualified names of classes");
//            System.out.println("Organization class name: " + organizationClass.getName());
//            System.out.println("Employee class name: " + employeeClass.getName());
//            System.out.println("HR class name: " + hrClass.getName());
//            System.out.println("Department class name: " + departmentClass.getName());
//
//            System.out.println();
//
//            // Run till here
//
//            // NOTE: This gives us only the class name
//            System.out.println("******* simple names of classes");
//            System.out.println("Organization class name: " + organizationClass.getSimpleName());
//            System.out.println("Employee class name: " + employeeClass.getSimpleName());
//            System.out.println("HR class name: " + hrClass.getSimpleName());
//            System.out.println("Department class name: " + departmentClass.getSimpleName());
//
//            System.out.println();

            /*creating a class handles from class names uisng class loaders
            use of Class.forName() to dynamically load class objects at runtime.
             */

            Class<?> organizationClass = Class.forName("com.reflection.Organization");
            Class<?> employeeClass = Class.forName("com.reflection.Employee");
            Class<?> hrClass = Class.forName("com.reflection.MainTwo$HR");
            Class<?> departmentClass = Class.forName("com.reflection.Department");

            System.out.println("******* toString() representations of custom class objects");
            System.out.println("Organization: " + organizationClass);
            System.out.println("Employee: " + employeeClass);
            System.out.println("HR: " + hrClass);
            System.out.println("Department: " + departmentClass);

            System.out.println();

            // Run till here

            Class<?> doubleClass = Class.forName("java.lang.Double");
            Class<?> hashSetClass = Class.forName("java.util.HashSet");
            Class<?> stringArrayClass = Class.forName("[[Ljava.lang.String;");
            Class<?> intArrayClass = Class.forName("[I");

            System.out.println("******* toString() representations of Java language class objects");
            System.out.println("Double: " + doubleClass);
            System.out.println("HashSet: " + hashSetClass);
            System.out.println("String array: " + stringArrayClass);
            System.out.println("int array: " + intArrayClass);

            System.out.println();
/*You can use Class.forName() to inspect and use a class at runtime:

      Class<?> enggClass = Class.forName("com.skillsoft.reflection.Main$Engineering");

        // Run this (this will be an error, note the ClassLoader in the error)
        Class.forName() is a method in Java used to dynamically load a class at runtime. It is commonly used for:
        Loading JDBC Drivers
        Reflection (inspecting class metadata, invoking methods dynamically, etc.)
        Plugin-based architectures
 */
           int modifier=organizationClass.getModifiers();
           System.out.println("Modifier: " + modifier);
           System.out.println("Binary modifier " + Integer.toBinaryString(modifier));

           /*This code uses Java Reflection to analyze the modifiers
           (such as public, private, abstract, final, static) of different classes at runtime.
            */
            //getModifiers() retrieves class modifiers as an integer.
            int organizationModifiers = organizationClass.getModifiers();
            System.out.println("Organization class modifiers: " + organizationModifiers);
            System.out.println("Organization class modifiers in binary format: " + Integer.toBinaryString(organizationModifiers));
            System.out.println("Public: " + Modifier.isPublic(organizationModifiers));
            System.out.println("Final: " + Modifier.isFinal(organizationModifiers));
            System.out.println("Abstract: " + Modifier.isAbstract(organizationModifiers));
            System.out.println("Static: " + Modifier.isStatic(organizationModifiers));

            System.out.println("*************** Deliverable");

            System.out.println("Is anonymous class: " + Deliverable.class.isAnonymousClass());
            System.out.println("Is local class: " + Deliverable.class.isLocalClass());
            System.out.println("Is interface: " +  Deliverable.class.isInterface());

            Deliverable webApplication = new Deliverable() {

                @Override
                public String getProjectName() {
                    return "Mongo Web Application";
                }

                @Override
                public String getProjectStatus() {
                    return "In Progress";
                }
            };
            System.out.println("*************** Instance of Deliverable (web application)");

            System.out.println("Is anonymous class: " + webApplication.getClass().isAnonymousClass());
            System.out.println("Is local class: " + webApplication.getClass().isLocalClass());
            System.out.println("Is interface: " +  webApplication.getClass().isInterface());

            /*This Java program demonstrates how to use reflection to check
            different characteristics of enums, arrays, and primitives at runtime.
             */

        }

    }
