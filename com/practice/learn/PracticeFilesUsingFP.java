package com.practice.learn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class PracticeFilesUsingFP {
    public static void main(String[] args) throws IOException {
        Files.lines(Paths.get("text.txt"))
                .map(str -> str.split(" "))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);

        //Hello
        //guys
        //some
        //random
        //text
        //here
        //hello
        //world
        //some
        //most
        //beautiful
        //places
        //around
        //the
        //world
        //We can also add distinct() and sorted() accordingly

        Files.list(Paths.get(".")).forEach(System.out::println);
        //.\.git
        //.\.idea
        //.\com
        //.\out
        //.\text.txt

        //You can see that it's printing all the files and the directories which are present at the root of this
        // specific project. Here if I want to filter out only the directories then simply add filter(Files::isDirectory).

        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
        //.\.git
        //.\.idea
        //.\com
        //.\out
        //As we can see that only the directories are now being printed.
    }
}
