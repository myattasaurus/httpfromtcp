package com.mattsploration.text;

import java.io.*;

public class _01_04ReadFile {

    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("messages.txt")) {
            byte[] eightBytes;
            while ((eightBytes = is.readNBytes(8)).length > 0) {
                System.out.println("read: " + new String(eightBytes));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
