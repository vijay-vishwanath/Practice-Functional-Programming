package com.practice.learn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PracticeStringJoinAndFlatMap {
    public static void main(String[] args) {
        List<String> courses  = List.of("Spring" , "Spring boot", "AWS", "Azure", "Microservices", "Docker", "Kubernetes", "GCP", "API", "PCF", "Angular", "React");
        List<String> courses2   = List.of("Spring" , "Spring boot", "AWS", "Azure", "Microservices", "Docker", "Kubernetes", "GCP", "API", "PCF", "Angular", "React");
        String str = courses.stream().collect(Collectors.joining(","));
        System.out.println(str);
        //"Spring,Spring boot,AWS,Azure,Microservices,Docker,Kubernetes,GCP,API,Angular,React" - collectors.joining will join all the strings in the list and return a single string

        courses.stream().map(a -> a.split("")).forEach(a -> System.out.println(Arrays.toString(a)));
        //Here we cannot call collect.(Collectors.toList()) method since:
        //Split function returns a stream of array so, this map function will return a stream of string arrays in a list as below.
        //[S, p, r, i, n, g]
        //[S, p, r, i, n, g,  , b, o, o, t]
        //[A, W, S]
        //[A, z, u, r, e]
        //[M, i, c, r, o, s, e, r, v, i, c, e, s]
        //[D, o, c, k, e, r]
        //[K, u, b, e, r, n, e, t, e, s]
        //[G, C, P]
        //[A, P, I]
        //[A, n, g, u, l, a, r]
        //[R, e, a, c, t]
        //But we want to convert the whole stream of arrays into individual strings in a list
        System.out.println(courses.stream().map(a -> a.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));
        //So here flatmap comes into play, it simply flattens all the stream of arrays into a single list and, now we
        //can collect it as a list without any issues.
        //[S, p, r, i, n, g, S, p, r, i, n, g,  , b, o, o, t, A, W, S, A, z, u, r, e, M, i, c, r, o, s, e, r,
        // v, i, c, e, s, D, o, c, k, e, r, K, u, b, e, r, n, e, t, e, s, G, C, P, A, P, I, A, n, g, u, l, a, r, R, e, a, c, t]
        //FlatMap() - Each element of stream replaced with contents of mapped stream. Here the mapping function -> Arrays::stream
        //["S","p","r","i","n","g"] => "S","p","r","i","n","g"
        //["A","W","S"]=> "A","W","S"

        //-----------Not understood the below snippet-----------------------------//yet to understand
        System.out.println(courses.stream().flatMap(course -> courses2.stream().map(course2 -> List.of(course,course2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList()));
        //[[Spring, Spring boot], [Spring, AWS], [Spring, Azure], [Spring, Microservices], [Spring, Docker], [Spring, Kubernetes], [Spring, GCP], [Spring, API], [Spring, PCF], [Spring, Angular], [Spring, React],
        // [Spring boot, Spring], [Spring boot, AWS], [Spring boot, Azure], [Spring boot, Microservices], [Spring boot, Docker], [Spring boot, Kubernetes], [Spring boot, GCP], [Spring boot, API], [Spring boot, PCF],
        // [Spring boot, Angular], [Spring boot, React], [AWS, Spring], [AWS, Spring boot], [AWS, Azure], [AWS, Microservices], [AWS, Docker], [AWS, Kubernetes], [AWS, GCP], [AWS, API], [AWS, PCF], [AWS, Angular],
        // [AWS, React], [Azure, Spring], [Azure, Spring boot], [Azure, AWS], [Azure, Microservices], [Azure, Docker], [Azure, Kubernetes], [Azure, GCP], [Azure, API], [Azure, PCF], [Azure, Angular], [Azure, React],
        // [Microservices, Spring], [Microservices, Spring boot], [Microservices, AWS], [Microservices, Azure], [Microservices, Docker], [Microservices, Kubernetes], [Microservices, GCP], [Microservices, API],
        // [Microservices, PCF], [Microservices, Angular], [Microservices, React], [Docker, Spring], [Docker, Spring boot], [Docker, AWS], [Docker, Azure], [Docker, Microservices], [Docker, Kubernetes], [Docker, GCP],
        // [Docker, API], [Docker, PCF], [Docker, Angular], [Docker, React], [Kubernetes, Spring], [Kubernetes, Spring boot], [Kubernetes, AWS], [Kubernetes, Azure], [Kubernetes, Microservices], [Kubernetes, Docker],
        // [Kubernetes, GCP], [Kubernetes, API], [Kubernetes, PCF], [Kubernetes, Angular], [Kubernetes, React], [GCP, Spring], [GCP, Spring boot], [GCP, AWS], [GCP, Azure], [GCP, Microservices], [GCP, Docker],
        // [GCP, Kubernetes], [GCP, API], [GCP, PCF], [GCP, Angular], [GCP, React], [API, Spring], [API, Spring boot], [API, AWS], [API, Azure], [API, Microservices], [API, Docker], [API, Kubernetes], [API, GCP],
        // [API, PCF], [API, Angular], [API, React], [PCF, Spring], [PCF, Spring boot], [PCF, AWS], [PCF, Azure], [PCF, Microservices], [PCF, Docker], [PCF, Kubernetes], [PCF, GCP], [PCF, API], [PCF, Angular],
        // [PCF, React], [Angular, Spring], [Angular, Spring boot], [Angular, AWS], [Angular, Azure], [Angular, Microservices], [Angular, Docker], [Angular, Kubernetes], [Angular, GCP], [Angular, API],
        // [Angular, PCF], [Angular, React], [React, Spring], [React, Spring boot], [React, AWS], [React, Azure], [React, Microservices], [React, Docker], [React, Kubernetes], [React, GCP], [React, API],
        // [React, PCF], [React, Angular]]

        System.out.println(courses.stream().flatMap(course -> courses2.stream().filter(course2 -> course2.length()==course.length())
                .map(course2 -> List.of(course,course2))).filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList()));
        //[[Spring, Docker], [AWS, GCP], [AWS, API], [AWS, PCF], [Azure, React], [Docker, Spring], [GCP, AWS], [GCP, API], [GCP, PCF],
        // [API, AWS], [API, GCP], [API, PCF], [PCF, AWS], [PCF, GCP], [PCF, API], [React, Azure]]


    }
}
