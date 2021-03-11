package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListUsersPage extends JPanel {
    JTable table;
    public ListUsersPage(MainFrame frame){
        setSize(500,500);
        setLayout(null);

        table = new JTable();

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100,100,300,250);
        add(scrollPane);

        JButton backButton = new JButton("BACK TO MENU");
        backButton.setBounds(100,350,300,40);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                frame.menuPage.setVisible(true);
            }
        });
    }
    public void generateTable(ArrayList<Student> students){
        Object[][] objects = new Object[students.size()][4];
        for (int i = 0; i<students.size(); i++){
            objects[i][0] = students.get(i).id;
            objects[i][1] = students.get(i).name;
            objects[i][2] = students.get(i).surname;
            objects[i][3] = students.get(i).age;
        }
        String [] header = {"ID","Name","Surname","Age"};
        DefaultTableModel tableModel = new DefaultTableModel(objects, header);
        table.setModel(tableModel);
    }
}
