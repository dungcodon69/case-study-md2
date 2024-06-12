package repositories;

import models.CustomerAccount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerAccountRepository {
    private static final String PATH = "src/data/CustomerAccount.csv";
    private static CustomerAccount[] customerAccounts = new CustomerAccount[10];

    static {
        customerAccounts[0] = new CustomerAccount("dung","1",100);
        customerAccounts[1] = new CustomerAccount("dung2","1",6000);
    }



    public List<CustomerAccount> getAll(){
        List<CustomerAccount> customerAccounts1 = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] split = line.split(",");
                CustomerAccount customerAccount = new CustomerAccount(split[0],split[1], Integer.parseInt(split[2]));
                customerAccounts1.add(customerAccount);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return customerAccounts1;
    }
}
