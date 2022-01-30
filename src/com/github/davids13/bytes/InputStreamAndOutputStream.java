package com.github.davids13.bytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamAndOutputStream {

    public static void main(String[] args) {

        byte[] header = {0xC, 0xA, 0xF, 0xE, 0xB, 0xA, 0xE};

        /* io */
        /* write bytes */
        try (OutputStream outputStream = new FileOutputStream("files/data.bin")) {
            outputStream.write(header);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* io */
        /* read bytes */
        try (InputStream inputStream = new FileInputStream("files/data.bin")) {
            byte[] allBytes = inputStream.readAllBytes();
            for (byte allByte : allBytes) {
                System.out.printf("0x%x ", +allByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
