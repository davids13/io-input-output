package com.github.davids13.object;

import com.github.davids13.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DemoObjectStream {

    public static void main(String[] args) {

        User u1 = new User("John", 50);
        User u2 = new User("Doe", 100);

        /* io */
        /* write Object into a file */
        try (FileOutputStream fileOutputStream = new FileOutputStream("files/user.bin");
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {

            outputStream.writeObject(u1);
            outputStream.writeObject(u2);

            System.out.println("Writing has done!!!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* io */
        /* read Object from a file */
        try (FileInputStream fileInputStream = new FileInputStream("files/user.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            User john = (User) objectInputStream.readObject();
            User doe = (User) objectInputStream.readObject();

            System.out.println("Reading Object John :: " + john);
            System.out.println("Reading Object Doe :: " + doe);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
