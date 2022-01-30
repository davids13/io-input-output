package com.github.davids13.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DemoBufferedWriter {

    public static void main(String[] args) {

        /* io */
        /* writing into a file */
        try (FileWriter fileWriter = new FileWriter("files/words-with-io.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            writer.write("writing to a buffered writer.");

            // flush the buffer otherwise "the text" it will stay in buffer
            // bufferedWriter.flush();
            // or with the BufferedWriter in try-with-resources the flushing is done automatically
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* nio (more clean) */
        /* writing into a file */

        /* Write text with try-with-resources (to flush & close automatically) with BufferedWriter */
        // Create Path
        Path path = Path.of("files/words-with-nio.txt");
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {

            // use it to write to your file
            bufferedWriter.write("writing to a buffered writer(with nio)");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
