package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddStudent extends JPanel {
    MainFrame parent;
    public AddStudent(MainFrame parent){
        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        JLabel nameLabel = new JLabel("NAME: ");
        nameLabel.setSize(300,30);
        nameLabel.setLocation(100,50);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setSize(250,40);
        nameField.setLocation(200,50);
        add(nameField);

        JLabel surnameLabel = new JLabel("SURNAME: ");
        surnameLabel.setSize(300,30);
        surnameLabel.setLocation(100,100);
        add(surnameLabel);

        JTextField surnameField = new JTextField();
        surnameField.setSize(250,40);
        surnameField.setLocation(200,100);
        add(surnameField);

        JLabel ageLabel = new JLabel("AGE: ");
        ageLabel.setSize(300,40);
        ageLabel.setLocation(100,150);
        add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setSize(250,40);
        ageField.setLocation(200,150);
        add(ageField);

        JButton addButton = new JButton("ADD");
        addButton.setSize(100,40);
        addButton.setLocation(100,350);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                String name = nameField.getText();
                nameField.setText("");
                String surname = surnameField.getText();
                surnameField.setText("");
                Integer age = Integer.valueOf(ageField.getText());
                ageField.setText("");
                Students student = new Students(null,name,surname,age);
                try {
                    parent.outputStream.writeObject(new PackageData("add",null,student));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        JButton backButton = new JButton("BACK");
        backButton.setSize(100,40);
        backButton.setLocation(320,350);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getAddStudentPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });

    }
}
