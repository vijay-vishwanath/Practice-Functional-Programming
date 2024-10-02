package com.practice.learn;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PracticeGroupingCourses {
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
        //groupingBy() -> It simply groups the elements based on criteria.
        System.out.println(courses.stream().collect(Collectors.groupingBy(PracticeCourses::getCategory)));
        //{Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:26000:91], FullStack=[FullStack:14000:89],
        // Microservices=[API:22000:97, Microservices:25000:96], Framework=[Spring:20000:98, Spring Boot:18000:95]}

        //Now I want to create it like a hashmap which contains category as the key and count as the pair
        System.out.println(courses.stream().collect(Collectors.groupingBy(PracticeCourses::getCategory, Collectors.counting())));
        //we can use counting() method to count the grouped elements.
        //{Cloud=4, FullStack=1, Microservices=2, Framework=2}

        //Now I want to group it in such a ways that, for each category, I only want the highest reviewed course
        System.out.println(courses.stream().collect(Collectors.groupingBy(PracticeCourses::getCategory,
                Collectors.maxBy(Comparator.comparing(PracticeCourses::getReviewScore)))));
        //Here I have used maxBy() function to fetch the maximum review score from the courses
        //and applied grouping to achieve the result.
        //{Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:89],
        // Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}

        //Now I want to group it with category and all the course names in each of the categories and convert it into a list
        System.out.println(courses.stream().collect(Collectors.groupingBy(PracticeCourses::getCategory,
                Collectors.mapping(PracticeCourses::getName, Collectors.toList()))));
        //here we have used mapping() where we can use that and it will return the names of the given courses
        //and returns as a list with all the names grouped with the category.
        //{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}


        //Now instead of mapping the entire course/all the courses, now I want to only
        //map the highest reviewed course name with the category

        System.out.println(courses.stream().collect(Collectors.groupingBy(
                PracticeCourses::getCategory,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(PracticeCourses::getReviewScore)),
                        course -> course.map(PracticeCourses::getName).orElse("")
                )
        )));
        //Here we have use collectingAndThen() -> this allows us to use a function further collecting, after we find
        //the course with the highest review score, the collectingAndThen collector is used to transform the result
        //into just the course name. The course.map(PracticeCourses::getName).orElse("") extracts the name if present,
        //and returns an empty string if no course is found.
        //{Cloud=Azure, FullStack=FullStack, Microservices=API, Framework=Spring}
        //and if we want to convert this into a list we have to add ..values().stream().collect(Collectors.toList());
        //This line will Extract the values (course names) from the Map and prints only the values in the list.

        Map<String, String> highestReviewedCoursesMap = courses.stream().collect(Collectors.groupingBy(
                PracticeCourses::getCategory,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparing(PracticeCourses::getReviewScore)),
                        course -> course.map(PracticeCourses::getName).orElse("")
                )
        ));
        System.out.println(highestReviewedCoursesMap);
        //{Cloud=Azure, FullStack=FullStack, Microservices=API, Framework=Spring}
        //We can also store the result in a hashmap if we want




    }
}
