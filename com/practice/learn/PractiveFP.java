package com.practice.learn;

import java.util.List;

public class PractiveFP {
    public static void main(String[] args) {
        List<Integer> list = List.of(34, 21, 56, 12, 53, 90, 78, 83);
        printEvenNumbers(list);

        printEvenNumberFunctional(list);
    }

    //Tradeitional Approach
    public static void printEvenNumbers(List<Integer> list){
        for(int number : list){
            if(number%2==0){
                System.out.println(number);
            }
        }
    }
    //creating a method here for checking even numbers
    public static boolean isEven(int number){
        return number%2==0;
    }
    public static void printEvenNumberFunctional(List<Integer> list){
        //Here I am filtering the even numbers from the stream of Integers and printing the even number using foreach loop
        list.stream()
                .filter(PractiveFP::isEven)   //Filter - only Allows even number, and it returns a stream
                .forEach(System.out::println);
    }

}


