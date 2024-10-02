package com.practice.learn;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeSkipLimitTakeWhileDropWhile {

    public static void main(String[] args) {
        List<PracticeCourses> courses = List.of(new PracticeCourses("Spring", "Framework", 98, 20000),
                new PracticeCourses("Spring Boot", "Framework", 95, 18000),
                new PracticeCourses("API", "Microservices", 97, 22000),
                new PracticeCourses("Microservices", "Microservices", 96, 25000),
                new PracticeCourses("FullStack", "FullStack", 89, 14000),
                new PracticeCourses("AWS", "Cloud", 92, 21000),
                new PracticeCourses("Azure", "Cloud", 99, 21000),
                new PracticeCourses("Docker", "Cloud", 92, 20000),
                new PracticeCourses("Kubernetes", "Cloud", 91, 26000)
        );

        Comparator<PracticeCourses> compareStudentsandReviews = Comparator.comparing(PracticeCourses::getNoOfStudents)
                                                                .thenComparing(PracticeCourses::getReviewScore);
        System.out.println(courses.stream().sorted(compareStudentsandReviews).limit(6).collect(Collectors.toList()));
        //Here the limit(6) function limits it to 6 sorted elements,
        //[FullStack:14000:89, Spring Boot:18000:95, Docker:20000:92, Spring:20000:98, AWS:21000:92, Azure:21000:99]
        //this is the functionality of limit.

        System.out.println(courses.stream().sorted(compareStudentsandReviews).skip(3).collect(Collectors.toList()));
        //Skip(n) function skips the first n number of elements and returns the rest of the elements
        //[Spring:20000:98, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96, Kubernetes:26000:91]

        //List of all elements : [Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96,
        //                        FullStack:14000:89, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:26000:91]

        System.out.println(courses.stream().takeWhile(course -> course.getReviewScore()>=95).collect(Collectors.toList()));
        //takeWhile() - returns all the elements until the first element breaks the condition, and
        //once the condition breaks it doesn't print the rest of the elements
        //[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96] - when condition breaks it stops
        System.out.println(courses.stream().dropWhile(course -> course.getReviewScore()>=95).collect(Collectors.toList()));
        //dropWhile() - opposite of takeWhile, once the first element breaks the condition, it returns the rest of the elements.
        //[FullStack:14000:89, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:26000:91]

    }
}
