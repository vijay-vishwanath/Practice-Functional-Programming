package com.practice.learn;

import java.util.List;

public class PracticeStreamMap {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 5, 6,3, 12, 51, 90, 87, 66, 34, 27, 13);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        printCourseUsingMap(courses);
        printNumberUsingMap(numbers);
    }
    //Map -> Basically when we are using [ stream().map(n -> n*n) ] --> Here we are
    //       replacing the number n with n*n which is the square of the original number.
    //And that is the use of map it simply maps the result to the original place

    public static void printNumberUsingMap(List<Integer> list){
        //EG 1 - print the cube of the odd numbers
        list.stream().filter(n -> n%2==1).map(n -> n*n*n).forEach(System.out::println);
        System.out.println("---------------------------------------------");
    }

    public static void printCourseUsingMap(List<String> list){
        //EG 2 -> Print the number of characters in each course name
        list.stream().map(str -> str.length()).forEach(System.out::println);
        System.out.println("---------------------------------------------");
    }
}
