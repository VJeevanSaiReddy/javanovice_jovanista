package com.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class GetMain {
    private static boolean isGetter(Method method) {
        if(!method.getName().startsWith("get")) return false;
        if(!((method.getModifiers() & Modifier.PUBLIC) ==Modifier.PUBLIC)){
            return false;
        }
        if(method.getReturnType().getName().equals("void")) return false;
        if(method.getParameterCount() != 0) return false;
        return true;
    }
    private static boolean isSetter(Method method) {
        if(!method.getName().startsWith("set")) return false;
        if(!((method.getModifiers() & Modifier.PUBLIC) ==Modifier.PUBLIC)){
            return false;
        }
        if(!method.getReturnType().getName().equals("void")) return false;
        if(method.getParameterCount() != 1) return false;
        return true;
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Class <?> employeeClass = Class.forName("com.reflection.NewEmployee");
        Method[] methods = employeeClass.getDeclaredMethods();
        for(Method method : methods){
            if(isGetter(method)){
                System.out.println(method.getName()+": getter \n");
            }
            else if(isSetter(method)) {
                System.out.println(method.getName() + ": setter \n");
            }
        }
        Method createEmployeeMethod = employeeClass.getMethod("createEmployee",String.class, String.class, double.class);
        NewEmployee newEmployee = (NewEmployee) createEmployeeMethod.invoke(null,"Nora","Accounts Manager",45000);
        System.out.println("Employee: "+ newEmployee);

        for(Method method: employeeClass.getDeclaredMethods()){
            if(method.getName().equals("setName")){
                method.invoke(newEmployee,"Hello");
            }
            else if(method.getName().equals("setTitle")){
                method.invoke(newEmployee,"Manager");
            }
            else if(method.getName().equals("setSalary")){
                method.invoke(newEmployee,33000);
            }
        }
        System.out.println("Updated Employee: "+ newEmployee);
        Method saveEmployeeMethod = employeeClass.getDeclaredMethod("save",String.class, String.class, String.class);
        boolean res=(boolean) saveEmployeeMethod.invoke(newEmployee,"some","username","Password");
        Method computeBonusInternalMethod = employeeClass.getDeclaredMethod("computeBonusInternal",float.class);
        computeBonusInternalMethod.setAccessible(true);
        double bonus=(double) computeBonusInternalMethod.invoke(newEmployee,0.5f);
        System.out.println("Bonus is "+ bonus);

    }
}
