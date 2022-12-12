package org.example;

import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Mobile Application Development with Java Sockets ");

        // initiate socket to connect to the server
        Socket socket = new Socket("localhost", 5000);

    }
}