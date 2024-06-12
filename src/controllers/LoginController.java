package controllers;

import models.User;
import views.LoginView;

public class LoginController {
    LoginView loginView = new LoginView();
    User user;
    public void login(){
        while (true){
            user = loginView.getUserAccount();
            if (checkLogin(user)){
                System.out.println("\u001B[43m✔Login success\u001B[0m");
                StaffController staffController = new StaffController();
                staffController.controllerStaff();
            }
            else {
                System.out.println("Wrong username or password. Please try again!");
            }
        }
    }

    private boolean checkLogin(User user) {
        return user.getUsername().equals("admin") && user.getPassword().equals("1");
    }


}
