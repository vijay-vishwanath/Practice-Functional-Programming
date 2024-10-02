package com.practice.learn;

import java.util.ArrayList;
import java.util.List;

public class PracticeModifyListUsingFP {
    public static void main(String[] args) {
        //replaceAll
        //removeIf

        List<String> courses  = List.of("Spring" , "Spring boot", "AWS", "Azure", "Microservices", "Docker", "Kubernetes", "GCP", "API", "PCF", "Angular", "React");
        //courses.replaceAll(n -> n.toUpperCase());
        //Exception in thread "main" java.lang.UnsupportedOperationException
        //	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
        //This above code snippet will throw and errror List.of() method returns an immutable list.

        List<String> modifyableCourses = new ArrayList<>(courses);
        modifyableCourses.replaceAll(n -> n.toUpperCase());
        System.out.println(modifyableCourses);
        //[SPRING, SPRING BOOT, AWS, AZURE, MICROSERVICES, DOCKER, KUBERNETES, GCP, API, PCF, ANGULAR, REACT]
        //Here we can modify because we have created a new arraylist which is mutable and, we have created a copy
        //of an arrayList so, we can modify that. Here we can use replaceAll() method to replace all the elements
        //in the list by giving the desired criteria
        modifyableCourses.removeIf(n -> n.length()<6);
        System.out.println(modifyableCourses);
        //[SPRING, SPRING BOOT, MICROSERVICES, DOCKER, KUBERNETES, ANGULAR]
        //Methods like this, which can accept a function as a parameter, makes it easy to modify the lists.
        //So, these kind of methods make it simple to program with lists in Java
    }
}
