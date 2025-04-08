package com.reflection;
import java.lang.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Employee jack=new Employee();
//        System.out.println(jack);
        Employee jane=new Employee("Jane", "VP", 124000);
//        System.out.println("Employee jane"+jane);
//        reflection, which allows dynamic inspection and manipulation of classes, methods, and fields at runtime.
        Class<?> employeeclass=jane.getClass();
        System.out.println("class for jane"+employeeclass);
        Field[] fields=employeeclass.getFields();
        System.out.println("fields for jane"+fields);
        for(Field f:fields){
            System.out.println(f);
        }
        Method[] methods=employeeclass.getMethods();
        System.out.println("Hellooooo\n");
        for(Method m:methods){
            System.out.println(m);
        }
        System.out.println("Hellooooo\n");
        Constructor<?>[] constructors=employeeclass.getConstructors();
        System.out.println("Constructors for jane"+constructors);
        for(Constructor c:constructors){
            System.out.println(c);
        }
//        System.out.println("Employee name"+jane.getName());
//        System.out.println("Employee title"+jane.getTitle());
//        System.out.println("Employee salary"+jane.getSalary());
//        System.out.println("Id:"+jane.getEmployeeId());
//        System.out.println("class for jane"+jane.getClass());
//        System.out.println("THE EMPLOYEE CLASS"+Employee.class);

         Integer integerObject=123;
        System.out.println(integerObject.getClass());
        System.out.println(Integer.class);

//        lets see how getclass method cannot or doesnot return the type parameter
        ArrayList arrayList=new ArrayList();
        System.out.println(arrayList.getClass());
        System.out.println(ArrayList.class);
        ArrayList<Integer> arrayList2=new ArrayList<Integer>();
        System.out.println(arrayList2.getClass());
        System.out.println(ArrayList.class);

//        getClass is always going to return the concreteclass that a particular object
//        belongs to.It does not matter whether that object happens to bea variable of an
//        interface or an abstract or a derived class.It's always going to
//        return the derived class that's the concrete implementationas the
//        output of the getClass invocation.
        System.out.println("\n");
        List<Float> FloatList=new ArrayList<Float>();
        System.out.println(FloatList.getClass());
        List<Double> DoubleList=new ArrayList<Double>();
        System.out.println(DoubleList.getClass());
    }
}