package com.generics;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        IntegerRepository integerRepository=new IntegerRepository(15);
        System.out.println(integerRepository);
        Repository<Integer> integerRepository1=new Repository<>(12);
        System.out.println(integerRepository1);
        integerRepository1.setValue(13);
        System.out.println(integerRepository1.getValue());
        Class<?> carClass= Class.forName("com.generics.Car");
        Constructor<?> constructor=carClass.getConstructor(String.class,String.class,Integer.class);
        Object carObject=constructor.newInstance("Honda","civic",21000);
        Repository<Car> carRepository=new Repository<Car>((Car) (carObject));
        System.out.println(carRepository);
        Map<Integer,Car> carMap=new HashMap<Integer,Car>();
        Car car1=new Car("Honda","civic",21000);
        Car car2=new Car("Hyundai","creta",41000);
        Car car3=new Car("Hyundai","i20",30000);
        Car[] cars=new Car[]{car1,car2,car3};
        Integer[] integers=new Integer[]{1,2,3};
        MapHelper.addEntries(carMap,integers,cars);
        MapHelper.printEntries(carMap);
    }
}
