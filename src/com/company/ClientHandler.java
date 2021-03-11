package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    public ClientHandler(Socket socket) throws IOException {
        start();
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());
    }
    @Override
    public void run() {
        while(true){
            String request = null;
            try {
                request = (String) inputStream.readObject();
                if (request.equals("addStudent")) {
                    Student student = (Student) inputStream.readObject();
                    Main.addStudent(student);
                    System.out.println(student.name+" "+student.surname+" added");
                }
                if (request.equals("getList")){
                    outputStream.writeObject(Main.getStudents());
                    System.out.println("List sent");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
