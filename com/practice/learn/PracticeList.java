package com.practice.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeList {
    public static void main(String[] args) {
       //Mutiple ways to create Arraylist
       // 1. Traditional Method
        List list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        list.add(6);

        //In Java 8
        List arrList = Arrays.asList(2,3,4,5,6,32,34);
        arrList.forEach(n -> System.out.println(n));

        // In Java 9 onwards
        List arrayList = List.of(4,5,6,3,2,1,45,21,63);
        arrayList.forEach(n -> System.out.println(n));
    }
}
