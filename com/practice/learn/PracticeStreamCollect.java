package com.practice.learn;

import java.util.List;
import java.util.stream.Collectors;

public class PracticeStreamCollect {
    public static void main(String[] args) {
        List<Integer> list = List.of(3,2,1,45,32,4,3,12,65,32,74,2,15,23,12,65,1);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        System.out.println(convertOddSquaredNumbers(list));
        System.out.println(evenNumbers(list));
        List<Integer> coursesLength = coursesLength(courses);
        System.out.println(coursesLength);
    }

    //using collect method we can return the stream as a list inside collect() method we to call toList() method from Collectors class.
    public static List<Integer> convertOddSquaredNumbers(List<Integer> list){
        return list.stream().filter(n -> n%2==1).map(n -> n*n).collect(Collectors.toList());
    }

    //EG 1 - Create a list with even numbers filtered from the numbers list
    public static List<Integer> evenNumbers(List<Integer> list){
        return list.stream().filter(n -> n%2==0).collect(Collectors.toList());
    }

    //EG 2 - Create a list with lenghts of all the courses title
    public static List<Integer> coursesLength(List<String> list){
        return list.stream().map(n -> n.length()).collect(Collectors.toList());
    }
}
