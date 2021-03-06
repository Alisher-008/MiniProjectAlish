package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler implements Runnable {
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    Server server;
    Socket socket;

    public ClientHandler(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        inputStream = new ObjectInputStream(socket.getInputStream());
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            PackageData pd = (PackageData) inputStream.readObject();
            if (pd.operationType.equals("add")) {
                server.addStudent(pd.getStudent());
            }
            else if(pd.operationType.equals("list")){
                outputStream.writeObject(server.listStudents());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
