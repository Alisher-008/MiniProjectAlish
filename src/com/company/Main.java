package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Connection connection;
    public static void main(String[]args) throws ClassNotFoundException, SQLException, IOException {
        Scanner in = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alish?useUnicode=true&serverTimezone=UTC","root", "");
        ServerSocket server = new ServerSocket(2223);
        while(true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            new ClientHandler(socket);
        }
    }
    public static void addStudent(Student s) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO students(id,name,surname,age) VALUES(null,?,?,?)");
        ps.setString(1, s.name);
        ps.setString(2, s.surname);
        ps.setInt(3, s.age);
        ps.executeUpdate();
        System.out.println("Row added");
    }
    public static ArrayList<Student> getStudents() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM students");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            int age = rs.getInt("age");
            students.add(new Student(id,name,surname,age));
        }
        return students;
    }
}
