package com.practice.learn;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PracticeCourses {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public PracticeCourses(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }

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
        //allMatch  ->  It uses Predicate FI and checks the condition on all the elements in list and return true if the conditon
        //              matches with all the elements in the list.
        //noneMatch ->  It also uses Predicate FI and checks the condition on all the elements in the list and return true if the
        //              condition does not match with any of the elements in the list. It is the opposite of allMatch().
        //anyMatch  ->  It also uses Predicate FI and checks the condition on all the elements in the list and return true,
        //              if any of the elements matches the given condition.

        Predicate<PracticeCourses> reviewScoreGreaterThan85 = course -> course.getReviewScore() > 85;
        Predicate<PracticeCourses> reviewScoreLesserthan90 = course -> course.getReviewScore() < 90;
        Predicate<PracticeCourses> reviewScoreGreaterThan95 = course -> course.getReviewScore() > 95;

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan85));
        System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan95));
        System.out.println(courses.stream().anyMatch(reviewScoreLesserthan90));

        //Now lets use comparators
        Comparator<PracticeCourses> comparingIncreasingOrder = Comparator.comparing(PracticeCourses::getNoOfStudents).reversed();
        Comparator<PracticeCourses> comparingDecreasingOrder = Comparator.comparing((PracticeCourses x) -> x.getNoOfStudents()).reversed();
        //Here important note to conisder, When I give just ((x) -> x.getNoOfStudents()).reversed(); we will get compilation error
        //because, the compiler struggles to infer the correct types, because the type of x is ambiguous to it. By default,
        //it treats x as an Object, and since Object doesn't have a getNoOfStudents() method, you get a compilation error.
        //So to avoid that we have to mention ((PracticeCourses x) -> x.getNoOfStudents()).reversed();

        System.out.println(courses.stream().sorted(comparingDecreasingOrder).collect(Collectors.toList()));
        //[FullStack:14000:89, Spring Boot:18000:95, Spring:20000:98, Docker:20000:92, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96, Kubernetes:26000:91]

        System.out.println(courses.stream().sorted(comparingIncreasingOrder).collect(Collectors.toList()));
        System.out.println(courses.stream().sorted(Comparator.comparing(PracticeCourses::getNoOfStudents)
                .thenComparing(PracticeCourses::getReviewScore)).collect(Collectors.toList()));

        //Here we can also use thenComparing() method to compare with next attribute like with review score,
        //now by adding this, first it will compare the noOfStudents and then for courses which has same number of students
        //it then compares with review score and sort them in order and gives the result


    }
}
