package com.practice.learn;

import java.util.List;

public class PracticeSumAverageCount {
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

        System.out.println(courses.stream().filter((PracticeCourses n)-> n.getReviewScore()>93)
                .mapToInt(PracticeCourses::getNoOfStudents).sum());
        //sum() - it adds the total of all the elements(here, noOfStudents) and returns the summation result 106000.
        //here we have used mapToInt() instead of map() since we are dealing with primitives,if we use map() here we get compilation error
        //because it returns an Integer object, in such case we would need to use reduce(0, Integer::sum)

        System.out.println(courses.stream().filter((PracticeCourses n)-> n.getReviewScore()>93)
                .mapToInt(PracticeCourses::getNoOfStudents).count());
        //count() -> this function simply returns the count of number of objects that meets the criteria.

        System.out.println(courses.stream().filter((PracticeCourses n)-> n.getReviewScore()>93)
                .mapToInt(PracticeCourses::getNoOfStudents).average());
        //average() - It will return the average of all the elements based on the count. here the average is
        //OptionalDouble[21200.0]. since 106000(sum)/5(count), it returns 21200.0
    }
}
