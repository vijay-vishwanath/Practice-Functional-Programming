package com.practice.learn;

import java.util.List;
import java.util.function.*;

public class PracticeBiFunctionalInterfaces {
    public static void main(String[] args) {
        //Here we are going to talk about BiPredicate, BiConsumer, BiFunction
        //So as the name states, these are simply the same but the only difference is it takes two parameters now

        BiPredicate<Integer, String> biP = (x , y) -> x%2 == 0 && y.length()>3;
        System.out.println(biP.test(12, "Mango"));
        //As we can see, here the bipredicates takes in two parameter and returns a boolean.

        BiFunction<Integer, Integer, String> biF = (a,b) -> a+" "+b;
        System.out.println(biF.apply(23, 45));
        //Here the biFunction takes two inputs and returns a result of string type.

        BiConsumer<Integer, String> biC = (a, b) -> {
            System.out.println(a);
            System.out.println(b);
        };
        biC.accept(23, "BiconsumerExample");
        //Here the biConsumer accepts two parameters and simply returns no result and prints the parameters passed.
    }
    //Also there other different types of the above functional Interfaces:
    //The use of the below functional interfaces are, when we are dealing with primitive its better to use the below FI.
    //Since we can avoid unnecessary boxing and unboxing.
         //IntBinaryOperator
         //IntConsumer
         //IntFunction
         //IntPredicate
         //IntSupplier
         //IntToDoubleFunction
         //IntToLongFunction
         //IntUnaryOperator

    public static void practicMethodReference(List<String> list){
        list.stream()
                .map(String::toUpperCase)      //Here as you can see I have used method reference for an instance method
                .forEach(System.out::println); //So now we know that, we can use method reference for both instance and static methods.

        Supplier<String> sup = () -> new String();   // ---------> 1
        //In here the supplier simply returns a new string. This can be done in another way as well
        //Constructor Reference : We can use this to create new objects
        Supplier<String> supplier = String::new;    // ----------> 2     and this is called constructor reference
        //both 1 and 2 simply returns a new object.
    }
}
