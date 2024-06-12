package controllers;

import models.Computer;
import models.CustomerAccount;
import models.Product;
import services.IStaffService;
import services.imp.StaffService;
import views.StaffView;

import java.util.List;

public class StaffController {
    StaffView staffView = new StaffView();
    IStaffService service = new StaffService();
    public void controllerStaff() {
        int choice;
        while (true){
            choice = staffView.showViewStaff();
            switch (choice){
                case 1:
                    System.out.println("You selected option 1");
                    break;
                case 3:
                    System.out.println("---Active customer account---");
                    Computer[] active = service.getActiveComputer();
//                    for (Computer c : active){
//                        System.out.println(c);
//                    }
                    staffView.showActiveCustomer(active);
                    break;
                case 4:
                    String username = staffView.addMoneyViewInputUsername();
                    int balance = staffView.addMoneyViewInputBalance();
                    boolean resultAddMoney = service.addMoney(username,balance);
                    if (!resultAddMoney) System.out.println("Some thing wrong. Try again!");
                    break;
                case 2:
                    Computer[] computers = service.getAllComputer();
                    for (Computer c : computers) System.out.println(c);
                    break;
                case 5:
                    List<Product> product = service.getAllProduct();
                    int choiceProductView = staffView.productView();
                    int idProduct = 0;
                    if (choiceProductView == 1){
                        idProduct = staffView.productSubMenu(product,1);
                    } else if (choiceProductView == 2){
                        idProduct = staffView.productSubMenu(product,2);
                    } else {
                        break;
                    }
                    int quantity = staffView.getQuantityInput();
                    String usernameProduct = staffView.getUsernameInput();
                    service.paymentProduct(idProduct,usernameProduct,quantity);
                    break;
                case 6:
                    int computerNumber = staffView.checkComputerNumber();
                    CustomerAccount customerAccount = staffView.checkCustomerAccount();
                    boolean resultTurnOn = service.turnOn(computerNumber,customerAccount);
                    if (!resultTurnOn) System.out.println("Some thing wrong. Try again!");
                    break;
                default:
                    System.out.println("Try again!");
            }
        }
    }
}
