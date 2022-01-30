package com.github.davids13.primitive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DemoDataStream {

    public static void main(String[] args) {

        /* DataStream: for read or write primitive types directly on streams of bytes */
        /* Integers to a Byte Array */

        int[] ints = {1, 2, 3, 4, 5};
        byte[] bytes = {};

        /* io */
        /* Write primitive types directly on streams of bytes */
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream)) {

            for (int integer : ints) {
                dataOutputStream.writeInt(integer);
            }

            // just to make sure the data has been properly flushed
            dataOutputStream.flush();

            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("bytes.length = " + bytes.length);

        /* io */
        /* Read primitive types directly on streams of bytes */
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
             DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream)) {

            for (int i = 0; i < ints.length; i++) {
                int readInt = dataInputStream.readInt();
                System.out.println("Reading: " + readInt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
