package com.reflection;
import java.lang.reflect.*;
import java.util.Arrays;
public class MainMethod {
    public static void main(String[] args) throws ClassNotFoundException{
        Class<?> c= Class.forName("java.lang.Object");
        Method[] methods = c.getMethods();
        for(Method m: methods){
            System.out.println(m.getName()+"\n");
            System.out.println(m.getReturnType().getName()+"\n");
            System.out.println(m.getParameterTypes().length);
            System.out.println(m+"\n");
        }
        Method[] methods2 = c.getDeclaredMethods();
        for(Method m: methods2){
            System.out.println(m.getName()+"\n");
            System.out.println(m+"\n");
        }
    }
}
