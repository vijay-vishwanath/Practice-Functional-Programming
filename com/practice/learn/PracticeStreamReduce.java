package com.practice.learn;

import java.util.List;

public class PracticeStreamReduce{
    public static void main(String[] args){
        List<Integer> list = List.of(3,2,1,45,32,12,65,32,74,15,23);
        System.out.println(traditionalSum(list));
        System.out.println("______________________");
        System.out.println(functionalSum(list));
    }
    //Traditional way to add the number
    public static int traditionalSum(List<Integer> list){
        int sum = 0;
        for(int number: list){
            sum += number;
        }
        return sum;
    }

    //before talking about functional way of summation of all the Integers in the list
    //Lets understand the below sum method simply returns the sum of two parameters passed inside.
    public static int sum(int a, int b){
        return a+b;
    }

    //Stream of numbers -> produce one result
    //So in order to achieve that we are going to use the reduce function
    //Basically reduce function takes in two parameters one is identity value(initial value) and accumulator(function/method)
    //Here we want to combine all the integers and produce one result and that is the end goal
    //So we are going to use  stream().reduce(0,PracticeStreamReduce::sum) -> this returns a reduced value(int, byte , long etc)
    //To perform aggregation operations this a roundabout way of doing it
    //****Reduction operations performed here are parellelized gracefully.
    public static int functionalSum(List<Integer> list){
          //return list.stream().reduce(0,PracticeStreamReduce::sum);
                               //or
           return list.stream().reduce(0, (a,b) -> a+b);
           //Lets understand something here. Here a -> is called aggreate and b -> next value
           //0 is the initial value assigned to a and next value(which is the first value in the list) gets added to a
           //a:0 + b:3 -> a:3 + b:2 -> a:5 + b:1 -> a:6 + b:45 -> a:51 + b:32 and so on.
           //Viola this is how the reduce function works
           //*********We can also use built in function (reduce(0, Integer::sum)) instead of lambda expression.
    }

}
