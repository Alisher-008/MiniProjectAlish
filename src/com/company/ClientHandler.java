package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    static int clients = 0;
    public ClientHandler(Server server,Socket socket) throws IOException {
        Scanner in = new Scanner(System.in);
         inputStream= new ObjectInputStream(socket.getInputStream());
         outputStream= new ObjectOutputStream(socket.getOutputStream());

         clients++;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    String name = (String) inputStream.readObject();
                    server.sendMessageToClients(name+"joined");
                    server.sendMessageToClients(clients+" cliented");
                    while (true){
                        String s = (String) inputStream.readObject();
                        System.out.println(name+": "+s);
                        server.sendMessageToClients(s);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while (true){
                        outputStream.writeObject(in.nextLine());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void sendMessage(String s) throws IOException {
        outputStream.writeObject(s);
        System.out.println("Message sent");
    }

    @Override
    public void run() {

    }
}
