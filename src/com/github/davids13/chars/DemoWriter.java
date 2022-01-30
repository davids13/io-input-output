package com.github.davids13.chars;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DemoWriter {

    public static void main(String[] args) {

        /* io */
        /* write chars */
        try (Writer writer = new FileWriter("files/write-words-with-chars.txt")) {

            writer.write("Hello World!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
