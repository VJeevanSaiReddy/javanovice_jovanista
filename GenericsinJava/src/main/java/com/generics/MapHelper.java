package com.generics;
import java.util.*;
public class MapHelper {
    public static <K,V> void addEntries(Map<K,V> map,K[] key,V[] value){
        int index = 0;
        for(K k:key ){
            map.put(k,value[index++]);
        }
    }
    public static <K,V> void printEntries(Map<K,V> map){
        for(Map.Entry<K,V> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        for(K k:map.keySet()){
            System.out.println(k+":"+map.get(k));
        }
    }
}
