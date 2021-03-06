package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.util.ArrayList;

public class ListStudents extends JPanel {
    MainFrame parent;
    JLabel listLabel;
    JButton backButton;
    JTextArea textArea;
    ObjectOutput outputStream;
    ObjectInputStream inputStream;
    // String header[] = {"id","name","surname","age"};
    //JTable table;
    //JScrollPane scrollPane;

    public ListStudents(MainFrame parent) {
        this.parent = parent;
        setSize(500, 500);
        setLayout(null);
        textArea = new JTextArea();
        textArea.setSize(300, 200);
        textArea.setLocation(100, 150);
        add(textArea);

        listLabel = new JLabel("LIST ALL STUDENTS: ");
        listLabel.setSize(300, 40);
        listLabel.setLocation(100, 50);
        add(listLabel);

        backButton = new JButton("BACK TO MENU");
        backButton.setSize(250, 40);
        backButton.setLocation(100, 100);
        add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getListStudentsPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
       /* table = new JTable();
        table.setFont(new Font("Calibri", Font.PLAIN, 12));
        table.setRowHeight(30);

        //Создаем панель для прокрутки
        scrollPane = new JScrollPane(table);
        scrollPane.setSize(300,200);
        scrollPane.setLocation(100,200);
        add(scrollPane);*/
    }

    public void fillTextArea() throws IOException, ClassNotFoundException {
        outputStream.writeObject(new PackageData("list", null, null));
        ArrayList<Students> students = (ArrayList<Students>) inputStream.readObject();
        for (Students s : students) {
            System.out.println(s);
        }
    }
    /*public void generateTable(Students[] students){
        Object data[][] = new Object[parent.students.size()][4];

        for(int i =0;i<parent.students.size();i++){
            data[i][0] = students[i].getId();
            data[i][1] = students[i].getName();
            data[i][2] = students[i].getSurname();
            data[i][3] = students[i].getAge();
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);

    }*/

}