package com.practice.learn;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeMaxMinFindFirstFindAny {
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

        Comparator<PracticeCourses> compareWithNumberAndReview = Comparator.comparing(PracticeCourses::getNoOfStudents)
                .thenComparing(PracticeCourses::getReviewScore).reversed();
        System.out.println(courses.stream().sorted(compareWithNumberAndReview).collect(Collectors.toList()));

        System.out.println(courses.stream().max(compareWithNumberAndReview));
        // Optional[FullStack:14000:89]
        //Max() -> this function takes in comparator and compares accordingly with our condition and returns
        //the last element with optional, Max doesn't mean it returns the maximum value in the list, it simply retuns the last element
        //As we can see Optional[FullStack:14000:89] has the least review score and no of students. but since we reversed(),
        //It simply fetches the last element

        System.out.println(courses.stream().min(compareWithNumberAndReview));
        //Optional[Kubernetes:26000:91]
        //As we can see min returns the first element with optional, although Optional[Kubernetes:26000:91] has the maximum number of students,
        //it doesn't mean it will return the minimum value from the stream of elements. It simply fetches the first element.

        //Lets understand Optional here.
        //We use optional to handle null values, because when return a null value and call a method on it, then it will cause null pointer
        //exception. So to avoid that we can use optional since it returns optional.empty if there is absence of value, and we can
        //use orElse() method to return a default value if the result is null.

        System.out.println(courses.stream().filter((PracticeCourses n) -> n.getReviewScore()<85).max(compareWithNumberAndReview));
        //Here in the above code snippet, it returns Optional.empty since there are no result found based on the filter criteria,
        //so here it return optional.empty
        System.out.println(courses.stream().filter((PracticeCourses n) -> n.getReviewScore()<85)
                .max(compareWithNumberAndReview).orElse(new PracticeCourses("GCP", "Cloud", 92, 19000)));
        //GCP:19000:92
        //Here in the same code snippet we are using orElse() and we are returning a default value, so now it will print that default value.
        System.out.println(courses.stream().filter((PracticeCourses n) -> n.getReviewScore()>95)
                .max(compareWithNumberAndReview).orElse(new PracticeCourses("GCP", "Cloud", 92, 19000)));
        //Spring:20000:98 -- In the above line, although it should show Optional[Spring:20000:98] but it only prints Spring:20000:98,
        //because here we have already set the default value if no result is found. so the optional will automatically be removed
        //when it gets printed

        System.out.println(courses.stream().filter((PracticeCourses n) -> n.getReviewScore()>95).findFirst());
        //findFirst() returns the first value which matches the criteria
        //It also returns an optional result. Optional[Spring:20000:98]
        //If no result were found then it would display Optional.empty

        System.out.println(courses.stream().filter((PracticeCourses n) -> n.getReviewScore()>95).findAny());
        //findAny() will return any value which matches the criteria
        //It also returns an optional result.
        //If no result were found then it would display Optional.empty
        //The behavior of this operation is explicitly nondeterministic; it is free to select any element in the stream.

    }
}
