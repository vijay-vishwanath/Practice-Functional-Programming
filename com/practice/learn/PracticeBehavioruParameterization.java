package com.practice.learn;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PracticeBehavioruParameterization {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4,8,2,43, 12, 8, 45, 23, 3, 1, 73, 6);
        List<Integer> listSquared = squareNumbersList(list, x->x*x );
    }
    public static void printLogic(List<Integer> list){
        //When we pass the logic of the method as an argument of a method i.e, when we are passing the behaviour
        //of the method as an argument then it is called behaviour parameterization

        Predicate<Integer> evenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer a) {
                return a % 2 == 0;
            }
        };

        Predicate<Integer> OddPredicate = n -> n % 2 == 1;

        list.stream().filter(evenPredicate).forEach(System.out::println);
        list.stream().filter(OddPredicate).forEach(System.out::println);
        //In the above two lines we have same logic except for the logic to find or even so this code
        //contains more repeated lines of the same code, so in order to avoid that

        //We have created a new method below which just takes the behaviour as a parameter(predicate) and filter and prints the same
        //this is called behavioural parameterization
        filterAndPrint(list, OddPredicate);
        filterAndPrint(list, evenPredicate);
        //If we want to print mutiples of 3 then
        filterAndPrint(list, n -> n%3==0);

    }

    private static void filterAndPrint(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(predicate).forEach(System.out::println);
    }

    //EG 1 - Do Behaviour parameterization for the mapping logic.
    //List squaredNumbers = numbers.stream().map( x-> x*x).collect(Collectors.toList);

    private static List<Integer> squareNumbersList(List<Integer> list, Function<Integer, Integer> function){
        return list.stream().map(function).collect(Collectors.toList());
    }


}
