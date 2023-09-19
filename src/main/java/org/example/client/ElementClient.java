package org.example.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ElementClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost",8081)) {
            OutputStream outputStream = socket.getOutputStream();
            byte[] bytes = "helloworld".getBytes();
            outputStream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
