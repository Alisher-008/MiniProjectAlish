package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    static ObjectInputStream inputStream;
    static ObjectOutputStream outputStream;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1",2223);
        inputStream = new ObjectInputStream(socket.getInputStream());
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
    public static void sendStudent(Student student) throws IOException {
        outputStream.writeObject("addStudent");
        outputStream.writeObject(student);
    }
    public static ArrayList<Student> getStudents() throws IOException, ClassNotFoundException {
        outputStream.writeObject("getList");
        ArrayList<Student> students = (ArrayList<Student>) inputStream.readObject();
        return students;
    }
}
