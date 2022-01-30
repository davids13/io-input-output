package com.github.davids13.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ReadImage {

    public static void main(String[] args) {

        /* https://mkyong.com/java/how-to-write-an-image-to-file-imageio/ */

        /* io */
        /* read an image */
        BufferedImage image = null;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

//            image = ImageIO.read(new File("images/spacex.jpg"));
            image = ImageIO.read(new File("images/free-jpg.jpeg"));
            System.out.println("Get image width: " + image.getWidth());

            // How to convert Image to Byte Array in java?
            ImageIO.write(image, "jpeg", byteArrayOutputStream);
            byte[] data = byteArrayOutputStream.toByteArray();
            System.out.println("\nConvert IMAGE to ARRAY: " + data);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
