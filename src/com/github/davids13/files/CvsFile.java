package com.github.davids13.files;

import com.github.davids13.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

public class CvsFile {

    public static void main(String[] args) {

        Path path = Path.of("files/data.csv");

        Function<String, Person> lineToPerson = CvsFile::lineToPerson;

        /* nio (more clean) */
        /* Read text with try-with-resources (to flush & close automatically) BufferedReader */
        try (BufferedReader reader = Files.newBufferedReader(path)) {

            // read all lines
            String lines = reader.readLine();
            while (lines != null) {
                if (!lines.startsWith("#")) {
                    Person person = lineToPerson.apply(lines);
                    System.out.println("Person :: " + person);
                }
                lines = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Person lineToPerson(String lines) {
        String[] elements = lines.split(";");

        String name = elements[0];
        int age = Integer.parseInt(elements[1]);
        String city = elements[2];

        return new Person(name, age, city);
    }


}
