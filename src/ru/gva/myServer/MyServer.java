package ru.gva.myServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("ждет");

        try (Socket clientSocket = serverSocket.accept()) {
            System.out.println("новое подключение");

            DataInputStream bf = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream bw = new DataOutputStream(clientSocket.getOutputStream());

            String str;
            while ((str = bf.readUTF()) != null) {

                System.out.println("пришло " + str);
                bw.writeUTF(str);
                System.out.println("ушло " + str);
                bw.flush();
            }

            bw.close();
            bf.close();
        }
    }
}
