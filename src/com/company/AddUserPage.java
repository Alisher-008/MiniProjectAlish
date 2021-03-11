package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddUserPage extends JPanel {
    public AddUserPage(MainFrame frame){
        setSize(500,500);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setBounds(100,100,100,40);
        add(nameLabel);

        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(200,100,200,40);
        add(nameTextField);

        JLabel surnameLabel = new JLabel("Surname: ");
        surnameLabel.setBounds(100,150,100,40);
        add(surnameLabel);

        JTextField surnameTextField = new JTextField();
        surnameTextField.setBounds(200,150,200,40);
        add(surnameTextField);

        JLabel ageLabel = new JLabel("AGE: ");
        ageLabel.setBounds(100,200,100,40);
        add(ageLabel);

        JTextField ageTextField = new JTextField();
        ageTextField.setBounds(200,200,200,40);
        add(ageTextField);

        JButton addButton = new JButton("ADD STUDENT");
        addButton.setBounds(100,250,300,40);
        add(addButton);

        JButton backButton = new JButton("BACK TO MENU");
        backButton.setBounds(100,300,300,40);
        add(backButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                nameTextField.setText("");

                String surname = surnameTextField.getText();
                surnameTextField.setText("");
                int age = 0;
                try {
                    age = Integer.parseInt(ageTextField.getText());
                    ageTextField.setText("");
                }catch (Exception exception){
                    age = 0;
                    ageTextField.setText("");
                }
                Student student = new Student(null,name,surname,age);
                try {
                    Client.sendStudent(student);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                frame.menuPage.setVisible(true);
            }
        });
    }
}
