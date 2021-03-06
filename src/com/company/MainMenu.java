package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenu extends JPanel {
    MainFrame parent;
    JButton addStudentButton;
    JButton listStudentsButton;
    JButton exitButton;
    public MainMenu(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        addStudentButton = new JButton("ADD STUDENT");
        addStudentButton.setSize(300,30);
        addStudentButton.setLocation(100,100);
        add(addStudentButton);
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getMainMenuPage().setVisible(false);
                parent.getAddStudentPage().setVisible(true);
            }
        });

        listStudentsButton = new JButton("LIST STUDENTS");
        listStudentsButton.setSize(300,30);
        listStudentsButton.setLocation(100,150);
        add(listStudentsButton);
        listStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getMainMenuPage().setVisible(false);
                parent.getListStudentsPage().setVisible(true);
                try {
                    parent.getListStudentsPage().fillTextArea();
                } catch (IOException | ClassNotFoundException ioException) {
                    ioException.printStackTrace();
                }
                // parent.getListStudentsPage().generateTable(parent.getStudents());
            }
        });

        exitButton = new JButton("EXIT");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,200);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}