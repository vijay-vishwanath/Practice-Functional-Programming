package com.practice.learn;

import java.util.List;
import java.util.stream.Stream;

public class Exercise {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 5, 6,3, 12, 51, 90, 87, 66, 34, 27, 13);
       List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
       printCourses(courses);
       printOddNumbers(numbers);
    }
    public static void printOddNumbers(List<Integer> list){
         //EG 1 - Print only odd numbers from the list
         list.stream().filter(n -> n%2==1).forEach(System.out::println);
    }

    public static void printCourses(List<String> list){
       //EG 2 - Print All courses individually
        list.stream().forEach(System.out::println);

        System.out.println("---------------------------------------------");
        //EG 3 - Print Courses containing word "Spring"
        list.stream().filter(str -> str.contains("Spring")).forEach(System.out::println);

        System.out.println("---------------------------------------------");
        //EG 4 - Print Courses Whose name has atleast 4 letters
        list.stream().filter(str -> str.length()>=4).forEach(System.out::println);
        System.out.println("---------------------------------------------");
    }

}
