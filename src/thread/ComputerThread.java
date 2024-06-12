package thread;

import models.Computer;
import models.CustomerAccount;

public class ComputerThread extends Thread{
    CustomerAccount customerAccount;
    Computer computer;

    public ComputerThread(CustomerAccount customerAccount, Computer computer) {
        this.customerAccount = customerAccount;
        this.computer = computer;
    }

    @Override
    public void run() {
        long remainTime;
        while (true){
            try {
                Thread.sleep(1000);
                customerAccount.setBalance(customerAccount.getBalance() - 100/60.0);
                remainTime = customerAccount.getRemainTime();
                if (remainTime <= 0){
                    customerAccount.setBalance(0);
                    computer.setState(0);
                    System.out.println();
                    System.out.println("\u001B[31m[CUSTOMER NOTIFY]:\u001B[0m Time up! " + customerAccount.getUsername() + " is out!");
                    break;
                }

//                System.out.println("Remain time: " + remainTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
