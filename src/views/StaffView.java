package views;

import models.Computer;
import models.CustomerAccount;
import models.Product;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class StaffView {
    Scanner scanner = new Scanner(System.in);
    public int showViewStaff(){
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║           \u001B[1m\u001B[33mSTAFF MENU\u001B[0m           ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║  1) Manage customer account    ║");
        System.out.println("║  2) Display all computer       ║");
        System.out.println("║  3) Show active customer       ║");
        System.out.println("║  4) Add money                  ║");
        System.out.println("║  5) Food / Drink               ║");
        System.out.println("║  6) Turn on computer           ║");
        System.out.println("║  7) Revenue report             ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.print(">> Choose an option: ");
        int choice;
        choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }


    public int checkComputerNumber() {
        System.out.print("Enter computer number: ");
        int number;
        number = Integer.parseInt(scanner.nextLine());
        return number;
    }

    public CustomerAccount checkCustomerAccount() {
        System.out.print("Enter customer username: ");
        String username = scanner.nextLine();
        System.out.print("Enter customer password: ");
        String password = scanner.nextLine();
        return new CustomerAccount(username,password);
    }

    public void showActiveCustomer(Computer[] active) {
        //System.out.println("┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.printf("┌%-20s┬%-20s┬%-20s┬%-20s┬%-20s┐%n","────────────────────","────────────────────","────────────────────","────────────────────","────────────────────");
        System.out.printf("│%-20s│%-20s│%-20s│%-20s│%-20s│%n","Computer Number","State","User","Balance","Remain Time");
        System.out.printf("├%-20s┼%-20s┼%-20s┼%-20s┼%-20s┤%n","────────────────────","────────────────────","────────────────────","────────────────────","────────────────────");

        for (int i = 0; i < active.length; i++) {
            System.out.printf("│%-20s│%-20s│%-20s│%-20.2f│%-20s│%n",active[i].getNumber(),active[i].getState() == 1 ? "ON" : "OFF",active[i].getUser().getUsername(),active[i].getUser().getBalance(), TimeUnit.MILLISECONDS.toMinutes(active[i].getUser().getRemainTime()) + ":" +(TimeUnit.MILLISECONDS.toSeconds(active[i].getUser().getRemainTime()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(active[i].getUser().getRemainTime()))));
            if (i == active.length - 1){
                break;
            }
            System.out.printf("├%-20s┼%-20s┼%-20s┼%-20s┼%-20s┤%n","────────────────────","────────────────────","────────────────────","────────────────────","────────────────────");
            //System.out.println(c);
        }
        System.out.printf("└%-20s┴%-20s┴%-20s┴%-20s┴%-20s┘%n","────────────────────","────────────────────","────────────────────","────────────────────","────────────────────");
        while(true){
            System.out.println(">> Enter \"r\" to reset or \"q\" to quit");
            String input = scanner.nextLine();
            if (input.equals("r")){
                System.out.printf("┌%-20s┬%-20s┬%-20s┬%-20s┬%-20s┐%n","────────────────────","────────────────────","────────────────────","────────────────────","────────────────────");
                System.out.printf("│%-20s│%-20s│%-20s│%-20s│%-20s│%n","Number","State","User","Balance","Remain Time");
                System.out.printf("├%-20s┼%-20s┼%-20s┼%-20s┼%-20s┤%n","────────────────────","────────────────────","────────────────────","────────────────────","────────────────────");
                for (int i = 0; i < active.length; i++) {
                    System.out.printf("│%-20s│%-20s│%-20s│%-20.2f│%-20s│%n",active[i].getNumber(),active[i].getState() == 1 ? "ON" : "OFF",active[i].getUser().getUsername(),active[i].getUser().getBalance(), TimeUnit.MILLISECONDS.toMinutes(active[i].getUser().getRemainTime()) + ":" +(TimeUnit.MILLISECONDS.toSeconds(active[i].getUser().getRemainTime()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(active[i].getUser().getRemainTime()))));
                    //System.out.printf("│%-20s│%-20s│%-20s│%-20s│%-20s│%n",active[i].getNumber(),active[i].getState(),active[i].getUser().getUsername(),active[i].getUser().getBalance(),active[i].getUser().getRemainTime());
                    if (i == active.length - 1){
                        break;
                    }
                    System.out.printf("├%-20s┼%-20s┼%-20s┼%-20s┼%-20s┤%n","────────────────────","────────────────────","────────────────────","────────────────────","────────────────────");
                    //System.out.println(c);
                }
                System.out.printf("└%-20s┴%-20s┴%-20s┴%-20s┴%-20s┘%n","────────────────────","────────────────────","────────────────────","────────────────────","────────────────────");
            } else if (input.equals("q")) {
                return;
            }
        }


    }

    public String addMoneyViewInputUsername() {
        System.out.print("Enter customer username: ");
        String name;
        name = scanner.nextLine();
        return name;
    }

    public int addMoneyViewInputBalance() {
        System.out.print("Enter money: ");
        int balance;
        balance = Integer.parseInt(scanner.nextLine());
        return balance;
    }

    public int productView() {
        System.out.println("1) Food");
        System.out.println("2) Drink");
        System.out.println("0) Back to main menu");
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }

    public int productSubMenu(List<Product> product, int choice) {
        if (choice == 1){
            for (Product p:
                 product) {
                if (p.getType().equals("food")){
                    System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice() + " " + p.getQuantity());
                }
            }
        }
        else if (choice == 2){
            for (Product p:
                    product) {
                if (p.getType().equals("drink")){
                    System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice() + " " + p.getQuantity());
                }
            }
        }
        System.out.println("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        return id;
    }

    public String getUsernameInput(){
        System.out.println("Enter username: ");
        return scanner.nextLine();
    }


    public int getQuantityInput() {
        System.out.println("Enter quantity: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
