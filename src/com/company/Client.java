package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("ENTER U NAME: ");
        String name = in.nextLine();
        Socket socket = new Socket("127.0.0.1", 2001);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        outputStream.writeObject(name);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        outputStream.writeObject(in.nextLine());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String s = (String) inputStream.readObject();
                        System.out.println(s);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        while (true) {

        }
    }
}
