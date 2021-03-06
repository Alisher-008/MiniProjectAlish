package com.company;

import javax.swing.*;
import java.io.ObjectOutput;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    ObjectOutput outputStream;
    MainMenu mainMenuPage;
    AddStudent addStudentPage;
    ListStudents listStudentsPage;
    ArrayList<Students> students = new ArrayList<>();
    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("STUDENTS APPLICATION");
        setLayout(null);
        setSize(500,500);

        mainMenuPage = new MainMenu(this);
        mainMenuPage.setVisible(true);
        add(mainMenuPage);

        addStudentPage = new AddStudent(this);
        addStudentPage.setVisible(false);
        add(addStudentPage);

        listStudentsPage = new ListStudents(this);
        listStudentsPage.setVisible(false);
        add(listStudentsPage);
    }

    public MainMenu getMainMenuPage() {
        return mainMenuPage;
    }

    public AddStudent getAddStudentPage() {
        return addStudentPage;
    }

    public ListStudents getListStudentsPage() {
        return listStudentsPage;
    }
}

