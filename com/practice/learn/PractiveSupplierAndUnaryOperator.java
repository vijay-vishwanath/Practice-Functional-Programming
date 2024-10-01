package com.practice.learn;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class PractiveSupplierAndUnaryOperator {

    //When we are talking about operator like Binary operator
    //it simply means the passing parameter and the returning result will be of same datatype unlike a function.

    //In function : Function<Integer, String> func = x -> x + "Hello world";
    //now the above line takes an integer as param and return a string

    //In BinaryOperator : BinaryOperator<Integer> BO = (x, y) -> x+y;
    //now the above line takes only one type of parameter as input and return the same type as result.
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4,8,2,43, 12, 8, 45, 23, 3, 1, 73, 6);

        Supplier<Integer> integerSupplier = () -> {    //If we want to code mutiple lines inside a lambda function then
            Random random = new Random();              //we will the curly braces to acheive that { .... }.
            return random.nextInt(100);
        };
        //What it does: It takes no parameter but returns a result.
        //It has a get() method in-built which will get the result.

        System.out.println(integerSupplier.get());

        UnaryOperator<Integer> UO = x -> x*x;
        System.out.println(UO.apply(10));
        //What it does :- it takes one parameter as input and returns the result of same datatype.
        //It has an apply(int b) method in-built which will takes an input and returns the result.
    }

}
