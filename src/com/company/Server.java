package com.company;

import com.mysql.cj.xdevapi.AddStatement;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
     ArrayList<ClientHandler> clients = new ArrayList<>();
    public Server() throws IOException {
        Scanner in = new Scanner(System.in);
        ServerSocket server = new ServerSocket(2001);

        while (true) {
            Socket socket = server.accept();
            ClientHandler clientHandler = new ClientHandler(this,socket);
            clients.add(clientHandler);
        }
    }
    public void sendMessageToClients(String s) throws IOException {
        for(ClientHandler ch: clients){
            ch.sendMessage(s);
        }
    }
}
