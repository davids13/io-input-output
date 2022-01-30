package com.github.davids13.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class DemoBufferedReader {

    public static void main(String[] args) {

        Path path = Path.of("files/sonnet.txt");
        System.out.println("The files exits? " + Files.exists(path));

        /* io */
        /* read a File line by line with a BufferedReader */
        try (FileReader fileReader = new FileReader("files/sonnet.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            /* Read line */
            String readLine = bufferedReader.readLine();

            /* Read all lines */
            while (readLine != null) {
                System.out.println("line: " + readLine);
                readLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* nio (more clean) */
        /* read a File line by line with a BufferedReader Stream (more clean) */
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            Stream<String> lines = bufferedReader.lines();
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* nio (more clean) */
        /* read text with Charset issue with try-with-resources with BufferedReader (to flush & close automatically) */
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            String line = reader.readLine();
            System.out.println("Read line: " + line);

            String lines = reader.readLine();
            while (lines != null) {
                System.out.println("Read all lines: " + lines);
                lines = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
