package com.practice.learn;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PracticeHigherOrderFunctions {
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

        Predicate<PracticeCourses> getReviewScoreGreaterThan90 = getCoursesPredicate(90);
        courses.stream().filter(getReviewScoreGreaterThan90);

        methodDummy();
        methodDummyOne();

    }
    private static Predicate<PracticeCourses> getCoursesPredicate(int reviewScore) {
        return a -> a.getReviewScore() > reviewScore;
    }

    //This way of creating a method which returns another method is called Higher order function.
    //Here we are treating method just like data, like passing we can store a data in a variable,
    //pass data to a method and return data from a method. We are now treating the same way for methods.
    //And this is what functional programming is all about.

    //Why Functional Programming is more efficient and have high performance than structural programming?
    //Lets see with a simple example

    public static void methodDummy(){
        List<String> course = List.of("Spring","API", "Microservices","Spring Boot","FullStack","AWS","Azure","Docker","Kubernetes");
        System.out.println(course.stream().peek(System.out::println).filter(a -> a.length()>7).map(a -> a.toUpperCase()).peek(System.out::println).findFirst());
        //Spring
        //API
        //Microservices
        //-----------------------End of first peek()
        //MICROSERVICES
        //-----------------------End of second peek()
        //Optional[MICROSERVICES] - Final result

        //Here unlike structural programming, which first filters all the elements which are greater than 7 and
        //converting into uppercase and then finding the first element and returning it.
        //Here if we see closely, it right gets the first element which is greater than 7 and doesn't even check or
        //look at the rest of the elements and converts the only element to uppercase and returns an Optional[MICROSERVICES]
        //hence we could say in FP it is much more efficient, since it already know we want only one element and looks
        //for the first element which matches the condition
        //Why FP is more efficient?
        //Because all the intermediate operations returns a stream back, and they are lazy, so they are not actually
        //executed when we are executing this piece of code:
        //course.stream().peek(System.out::println).filter(a -> a.length()>7).map(a -> a.toUpperCase()).peek(System.out::println)
        //they are only executed when we execute the terminal operation which is findFirst();
        //the intermediate operations only get executed when it knows what to expect as a result.

    }
    //Improving performance with parellization of streams:
    public static void methodDummyOne(){
        long time = System.currentTimeMillis();
        System.out.println(LongStream.range(0,1000000000).sum());
        System.out.println(System.currentTimeMillis()-time);
        //561 milliseconds - it took this much time to perform this operation
        //Now,
        //If you're using functional programming, it's very easy to improve the performance we just have to do something
        //called .parallel() and say .sum(). Let's see how much time this takes. Let's run as a Java Application.
        System.out.println(LongStream.range(0,1000000000).parallel().sum());
        System.out.println(System.currentTimeMillis()-time);
        //54 milliseconds - It nearly 90 percent faster.
        //One question you might be asking is, why is it easy to parallelize functional code.
        //Why can't I just parallelize structured code?
        //The problem with structured code, typically, is that we have a lot of state present.
        //what I mean by state?
        List<Integer> numbers = List.of(4,3,2,1,345,3,2434,345,6,2);
        int sum =0;
            for(int number:numbers){
                sum += number;
            }
        System.out.println(sum);
        //Here, In the above code, The thing is, the sum has an initial value and as we loop, we keep appending,
        //we keep adding to the sum and therefore, the value of this variable sum keeps changing
        // that's why, we cannot run it in two different cores. So, what Java does is, it would run the entire method
        // in a single core because we have state in here. because we have a variable whose value is changing all the time.

        //But in case of Functional approach,
        //The way we did it was we said numbers.stream(),we created a stream, and then we defined what operation needs
        //to be done on that specific stream. Now, if I add a .parallel() in here, if I had a ,parallel() in here,
        //then we are telling Java that we can execute this stream in a parallel way. What Java can do is,
        //actually split the stream into multiple parts and execute these operations on those multiple parts and finally,
        //combine the results of all those multiple parts. So, if I have a list of, let's say, 200000 numbers,
        //what Java can do is, it can break it into 100000 numbers and one more 100000 numbers and execute these operations
        //separately for each of the 100000 numbers and finally, use the same operation to combine the result. So,
        //what it can do is, it can run the part one on one core, part two on another core and finally, merge the results.
        //And that's where the efficiency of functional programming comes into picture.
    }



}
