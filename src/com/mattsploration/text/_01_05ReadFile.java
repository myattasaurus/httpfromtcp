package com.mattsploration.text;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class _01_05ReadFile {

    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("messages.txt")) {
            byte[] eightBytes;
            System.out.print("read: ");
            while ((eightBytes = is.readNBytes(8)).length > 0) {
                String chunk = new String(eightBytes).replaceAll("\n", "\nread: ");
                System.out.print(chunk);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
