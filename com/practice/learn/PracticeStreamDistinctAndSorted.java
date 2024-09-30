package com.practice.learn;

import java.util.Comparator;
import java.util.List;

public class PracticeStreamDistinctAndSorted {
    public static void main(String[] args) {
        List<Integer> list = List.of(3,2,1,45,32,4,3,12,65,32,74,2,15,23,12,65,1);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        printDistinctElements(list);
        System.out.println("********************************");
        printSortedInList(list);
        System.out.println("********************************");
        printSortedInReverse(list);
        System.out.println("********************************");
        printSortedCourseUsingLength(courses);
    }
    //Distinct will return a stream of distinct elements eliminating the duplicates
    public static void printDistinctElements(List<Integer> list){
        list.stream().distinct().forEach(System.out::println);
    }
    //Sorted() method will simply return a stream of sorted elements in the list
    //Basically sorted will sort in a 'natural order' of the elements like if it is a string of elements then it will sort it in
    //alphabetical order and if it integers it will sort it in ascending order.
    public static void printSortedInList(List<Integer> list){
       list.stream().sorted().forEach(System.out::println);
    }

    //sorted(comparator.naturalOrder()) and sorted() -> are same
    //but By explicitly mentioning sorted(comparator.reverseOrder()) -> Now this will print everything in descending format
    public static void printSortedInReverse(List<Integer> list){
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    //We can also use Comparator.comparing() and inside comparing method we can define the lambda expression according to our condition
    //eg : if we want to sort the elements based on the length of the string then we can define it like comparing(n -> n.length())
    //or we can also use method reference like (String::length) instead of the above lambda expression
    public static void printSortedCourseUsingLength(List<String> list){
        list.stream().sorted(Comparator.comparing(n -> n.length())).forEach(System.out::println);
    }

    
}
