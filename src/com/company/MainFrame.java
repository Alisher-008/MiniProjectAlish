package com.company;

import javax.swing.*;

public class MainFrame extends JFrame {
    AddUserPage addUserPage;
    ListUsersPage listUsersPage;
    MenuPage menuPage;
    public MainFrame(){
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Student Application");

        menuPage = new MenuPage(this);
        add(menuPage);
        menuPage.setVisible(true);

        addUserPage = new AddUserPage(this);
        add(addUserPage);
        addUserPage.setVisible(false);

        listUsersPage = new ListUsersPage(this);
        add(listUsersPage);
        listUsersPage.setVisible(false);
    }
}
