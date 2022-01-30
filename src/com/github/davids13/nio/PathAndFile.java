package com.github.davids13.nio;

import java.io.File;
import java.nio.file.Path;

public class PathAndFile {

    public static void main(String[] args) {

        /* The NIO package introduced a low-level API for non-blocking IO, while NIO.2 introduced better file management. */

        /* Manipulating Files with Path (java ee 11) */
        Path path = Path.of("files/sonnet.txt"); // java 11 (USE THIS)
        System.out.println("NIO :: Path - " + path);

        /* Manipulating Files with File */
        File file = new File("files/sonnet.txt");
        System.out.println("IO :: File - " + file);

    }
}
