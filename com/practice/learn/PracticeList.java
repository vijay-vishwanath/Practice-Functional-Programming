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
        //But this will produce a immutable arrayList

        //This is how we print the list in structured way
        printStructured(arrList);

        //This is how we print in functional programming way
        printFunctional(arrayList);
    }

    public static void printStructured(List<Integer> list){
        for(Integer number : list){
            System.out.println(number);
        }
    }

    public static void print(int number){
        System.out.println(number);
    }

    public static void printFunctional(List<Integer> list){
        //Here we are calling the stream of integers from the list using method reference by using class name
        //we are calling print method to print the stream of Integers
        list.stream().forEach(PracticeList::print);
                  //or
        list.stream().forEach(System.out::println);
    }
    // Terminal Operations:
    //Terminal operations are the final operations performed on a stream, producing a result or side effect. They:
    //- Consume the stream
    //- Produce a result or side effect
    //- Cannot be reused
    //Examples of terminal operations:
    //- forEach()
    //- collect()
    //- reduce()
    //- findFirst()
    //- findAny()
    //- min()
    //- max()
    //- count()
    //- sum()
    //- average()

    //2. Intermediate Operations:
    //Intermediate operations transform or filter the stream, returning a new stream. They:
    //- Do not consume the stream
    //- Return a new stream
    //- Can be chained
    //Examples of intermediate operations:
    //- filter()
    //- map()
    //- flatMap()
    //- distinct()
    //- sorted()
    //- limit()
    //- skip()
}
