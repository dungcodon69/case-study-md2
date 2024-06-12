package views;

import models.User;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);

    public User getUserAccount(){
        System.out.println("┌──────────────┐");
        System.out.println("│ PLEASE LOGIN │");
        System.out.println("└──────────────┘");
        System.out.print("│Username:");
        String username = scanner.nextLine();
        System.out.print("│Password:");
        String password = scanner.nextLine();
        return new User(username,password);
    }
}
