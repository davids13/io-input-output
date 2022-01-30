package com.github.davids13.chars;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class DemoReader {

    public static void main(String[] args) {

        /* io */
        /* read chars */
        try (Reader reader = new FileReader("files/sonnet.txt")) {

            // read chars from FileReader
            char[] buf = new char[16];
            int read = reader.read(buf);
            StringBuilder stringBuilder = new StringBuilder();

            while (read > 0) {
                stringBuilder.append(buf, 0, read);
                read = reader.read(buf);
            }

            System.out.println("read chars: " + stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
