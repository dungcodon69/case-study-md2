package services.imp;

import models.Computer;
import models.CustomerAccount;
import models.PaymentHistory;
import models.Product;
import repositories.ComputerRepository;
import repositories.CustomerAccountRepository;
import repositories.PaymentHistoryRepository;
import repositories.ProductRepository;
import services.IStaffService;
import thread.ComputerThread;

import java.time.LocalDateTime;
import java.util.List;

public class StaffService implements IStaffService {
    ComputerRepository computerRepository = new ComputerRepository();
    CustomerAccountRepository customerAccountRepository = new CustomerAccountRepository();
    Computer[] computers = ComputerRepository.getComputers();
    List<CustomerAccount> customerAccounts = customerAccountRepository.getAll();
    ProductRepository productRepository = new ProductRepository();
    PaymentHistoryRepository paymentHistoryRepository = new PaymentHistoryRepository();
    @Override
    public boolean turnOn(int number, CustomerAccount customerAccount) {
        for (int i = 0; i < computerRepository.size(); i++) {
            if (computers[i].getNumber() == number && computers[i].getState() == 0){
                // TODO : Check customer account
                for (int j = 0; j < customerAccounts.size(); j++) {
                    if (customerAccounts.get(j).getUsername().equals(customerAccount.getUsername())){
                        if (customerAccounts.get(j).getBalance() > 0){
                            customerAccounts.get(j).setStartTime(System.currentTimeMillis());
                            computerRepository.turnOn(i,customerAccounts.get(j));
                            System.out.println("Turn on computer number "+i);
                            ComputerThread computerThread = new ComputerThread(customerAccounts.get(j),computers[i]);
                            computerThread.start();
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    @Override
    public Computer[] getActiveComputer() {
        int size = 0;
        for (int i = 0; i < computerRepository.size(); i++) {
            if (computers[i].getState() == 1) size++;
        }
        Computer[] computers1 = new Computer[size];
        int index = 0;
        for (int i = 0; i < computerRepository.size(); i++) {
            if (computers[i].getUser() != null){
                computers1[index] = computers[i];
                index++;
            }

        }
        return computers1;
    }

    @Override
    public boolean addMoney(String username,int balance) {
        for (int i = 0; i < customerAccounts.size(); i++) {
            if (customerAccounts.get(i).getUsername().equals(username)){
                customerAccounts.get(i).updateBalance(balance);
                return true;
            }
        }
        return false;
    }

    @Override
    public Computer[] getAllComputer() {
        Computer[] computers1 = ComputerRepository.getComputers();
        return computers1;
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAll();
    }

    @Override
    public boolean paymentProduct(int id,String username,int quantity) {
        Product product = productRepository.findProductById(id);
        PaymentHistory paymentHistory = new PaymentHistory(LocalDateTime.now(),username,product.getId(),quantity,product.getPrice());
        paymentHistoryRepository.writeFile(paymentHistory);
        return true;
    }


}
