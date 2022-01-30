package com.github.davids13.characteresbytes;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class WritingAndReadingCharactersFromBytes {

    public static void main(String[] args) {

        String devOps = "Jenkins; Docker; Kubernetes;";

        /* io */
        /* writing string in array of bytes */
        ByteArrayOutputStream buffer = null;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             OutputStreamWriter writer = new OutputStreamWriter(byteArrayOutputStream)) {

            writer.write(devOps);
            buffer = byteArrayOutputStream;

        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = buffer.toByteArray();
        System.out.println("ARRAY OF BYTES: " + bytes);

        /* io */
        /* reading string in array of bytes */
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
             InputStreamReader reader = new InputStreamReader(byteArrayInputStream);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String readLine = bufferedReader.readLine();
            System.out.println("Read line: " + readLine);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
