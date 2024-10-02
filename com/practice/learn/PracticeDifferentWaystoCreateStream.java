package com.practice.learn;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class PracticeDifferentWaystoCreateStream {
    public static void main(String[] args) {
        //So far we have created streams this way
        List<Integer> list = List.of(2,9,5,21,45,32,22,65,34,65,84,16,28,73);
        //now,
        System.out.println(list.stream());
        //java.util.stream.ReferencePipeline$Head@15aeb7ab
        //---->creating stream this way will make the elements in the list as wrapper types

        //we can also create streams like this:
        Stream.of(2,9,5,21,45,32,22,65,34,65,84,16,28,73);
        //and peform operation such as:
        System.out.println(Stream.of(2,9,5,21,45,32,22,65,34,65,84,16,28,73).reduce(0, Integer::sum));;
        //501 - output
        System.out.println(Stream.of(2,9,5,21,45,32,22,65,34,65,84,16,28,73));
        //java.util.stream.ReferencePipeline$Head@7b23ec81
        //This will also create a stream of integers with wrapper type only.

        //So In order to create a stream of primitive type values we can use Arrays.stream() method
        int[] numArray = {2,9,5,21,45,32,22,65,34,65,84,16,28,73};
        System.out.println(Arrays.stream(numArray).sum()); //501
        System.out.println(Arrays.stream(numArray).min()); //OptionalInt[2]
        System.out.println(Arrays.stream(numArray).max()); //OptionalInt[84]
        System.out.println(Arrays.stream(numArray).count()); //14

        System.out.println(Arrays.stream(numArray));
        // java.util.stream.IntPipeline$Head@12edcd21
        //Now as we could see this create a IntPipeLine instead of referencePipeline

        //How to create a stream of consecutive numbers(like for first 100 numbers, even numbers, or like with any pattern)
        System.out.println(IntStream.range(0,10).sum());
        //This IntStream will create a stream of primitive integers with the range mentioned
        //Now the output here is 45 instead of 55 because range() function will exclude the last digit, so
        System.out.println(IntStream.rangeClosed(0,10).sum());
        //55 -> rangeClosed() will include the last digit as well

        //now lets generate stream of values based on our own algorithmic pattern
        IntStream.iterate(2, a -> a * 2).limit(10).forEach(System.out::println);
        // 2 4 8 16 32 64 128 256 512 1024
        //So here whenever we use iterate() to create our own pattern of elements if we don't limit it then it will
        //automatically create infinite number of elements.

        System.out.println(IntStream.iterate(2, a -> a * 2).limit(10).peek(System.out::println).sum());
        //So basically peek method will allow us to see through the stream of data which will be passed between methods.
        //If we simply use peek() method at the end of the program it will not show us anything since there are no methods
        //being called at the end.

        //Now, Lets see How can we convert this primitive IntStream into a list
        //We cannot directly call collect(Collectors.toList()) method as the values are in primitive int.
        List<Integer> intStreamData = IntStream.iterate(1, a -> a * 2).limit(20).boxed().collect(Collectors.toList());
        System.out.println(intStreamData);
        //[1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288]
        //So, Here we use boxed() method to box the primitive to wrapper Integers and then we can convert the whole stream of data into a list.

        //Now lets do a simple factorial problem using streams, factorial of 1 to 20
        System.out.println(IntStream.rangeClosed(1,20).reduce(1, (a,b) -> a*b));
        //-2102132736 - Now this above code snippet returns a negative value because the result is bigger than the int max value;
        System.out.println(LongStream.rangeClosed(1,20).reduce(1, (a, b) -> a*b));
        //2432902008176640000 - In such case we can use long stream but even long stream cannot give the
        //value of 50! so In such case we have to use bigIntegers
        System.out.println(LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
        //30414093201713378043612608166064768844377641568960512000000000000 - output
        //So here we are using mapToObj() function to map it to BigInteger Object, and then we are calling the valueOf to return a
        //BigInteger. BigInteger.ONE means, it starts with 1, and we are giving it as identity and for the accumulator
        //we are giving BigInteger::multiply for multiplication.















    }
}
