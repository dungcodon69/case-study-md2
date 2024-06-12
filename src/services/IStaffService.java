package services;

import models.Computer;
import models.CustomerAccount;
import models.Product;

import java.util.List;

public interface IStaffService {
    boolean turnOn(int number, CustomerAccount customerAccount);
    Computer[] getActiveComputer();

    boolean addMoney(String username,int balance);
    Computer[] getAllComputer();
    List<Product> getAllProduct();
    boolean paymentProduct(int id,String username,int quantity);
}
