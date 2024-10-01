package com.practice.learn;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PracticeFunctionInterface {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4,8,2,43, 12, 8, 45, 23, 3, 1, 73, 6);
        printLogicOne(list);
        System.out.println("-------------------------------------------");
        System.out.println(sumOfNumberInList(list));
    }
    //How does Lambda expressions works for the below scenarios
    public static void printLogic(List<Integer> list){
        list.stream().filter(a -> a%2==0)
                .map(a -> a*a).forEach(System.out::println);
    }
    //In the above scenario we have filter(), map() and forEach() methods used here, lets expand and see how it actually looks:
    /*
    boolean isEven(int x){
        if(x&2==0) return x;
        }

    int squared(int x){
        return x*x;
        }

    void print(int x){           forEach(System.out::println) ->(since method reference is simplification for lambda expression)
        System.out.println(x)    since n -> System.out.println(n); are same as above
        }
     */

    //Now lets extract the printlogic() lambda expressions into local variables
    public static void printLogicOne(List<Integer> list){
        Predicate<Integer> predicate = a -> a % 2 == 0;
        //What it does: accepts one argument to it, and it always returns a boolean
        Function<Integer, Integer> function = a -> a * a;
        //What it does: accepts one argument to it, and it returns a result
        Consumer<Integer> consumer = System.out::println;
        //What it does: accepts one argument to it, and it returns no result(void)


        //Here as we can see, there are few functional interfaces behind each implemented lambda expressions.
        //***A functional interface should have only one abstract method but it also can have multiple static and default methods.
        //Expanding the all the above interfaces to understand better

        Predicate<Integer> predicateIsEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2==0;
            }
        };

        Function<Integer, Integer> functionSquared = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x*x;
            }
        };

        Consumer<Integer> consumerPrint = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        //Here, the same if we want to create an instance of an interface then we would have to implement
        //the body of the methods present in the interface as well, unlike classes just by using new keyword and the name of
        // the class we can create an instance of that class.

        list.stream().filter(predicate)
                .map(function).forEach(consumer);
    }
        //EG 1 - Find functional interface behind the second argument of the reduce method. create an implementation of the
        //functional interface. int sum = numbers.stream().reduce(0, Integer::sum);

        public static int sumOfNumberInList(List<Integer> list){

            BinaryOperator<Integer> sum = Integer::sum;    //(a, b) -> a+b; and Integer::sum are same.
            //BinaryOperator -> functional interface used here.
            //What it does: accepts two arguments of the same type, producing a result of the same type as the arguments.

            BinaryOperator<Integer> sumOfNumbers = new BinaryOperator<Integer>() {
                @Override
                public Integer apply(Integer a, Integer b) {
                    return a+b;
                }
            };

            return list.stream().reduce(0, sumOfNumbers);
        }
}
