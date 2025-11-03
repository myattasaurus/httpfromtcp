package com.mattsploration.text;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class _02_01TCPRun {

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(42069)) {
            while (true) {
                Socket client = server.accept();
                System.out.println("Connection accepted");
                getLines(client.getInputStream());
                System.out.println("\nConnection closed");
            }
        }
    }

    public static void getLines(InputStream is) {
        try (is) {
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
