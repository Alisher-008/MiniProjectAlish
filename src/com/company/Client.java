package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        Scanner in = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 3000);
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

        while (true) {
            System.out.println("PRESS [1] TO ADD STUDENT");
            System.out.println("PRESS [2] TO LIST STUDENTS");
            System.out.println("PRESS [0] TO EXIT");
            String choice = in.next();
            if (choice.equals("1")) {
                System.out.println("INSERT NAME: ");
                String name = in.next();
                System.out.println("INSERT SURNAME: ");
                String surname = in.next();
                System.out.println("INSERT AGE: ");
                int age = in.nextInt();
                Students student = new Students(null, name, surname, age);
                outputStream.writeObject(new PackageData("add",null,student));
            } else if (choice.equals("2")) {
                outputStream.writeObject(new PackageData("list", null, null));
                ArrayList<Students> students = (ArrayList<Students>) inputStream.readObject();
                for (Students s : students) {
                    System.out.println(s);
                }
            }
            else if(choice.equals("0")){
                break;
            }
            else {
                System.out.println("ERROR");
            }
        }
    }
}

