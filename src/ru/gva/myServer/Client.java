package ru.gva.myServer;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try (Socket clSocket = new Socket("0.0.0.0", 8080)) {

            DataInputStream bf = new DataInputStream(clSocket.getInputStream());
            DataOutputStream bw = new DataOutputStream(clSocket.getOutputStream());
            String asd = sc.nextLine();
            bw.writeUTF(asd);
            bw.flush();
//
            while ((asd = bf.readUTF()) != "exit"){
                if (asd == "exit") break;
                System.out.println("пришло " + asd);

                asd = sc.nextLine();
                bw.writeUTF(asd);
                System.out.println("отправили " + asd);
            }

            bf.close();
            bw.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
