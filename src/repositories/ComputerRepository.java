package repositories;

import models.Computer;
import models.CustomerAccount;

public class ComputerRepository {
    private static Computer[] computers = new Computer[10];
    private static int size;
    static {
        for (int i = 0; i < computers.length; i++) {
            computers[i] = new Computer(i);
        }
        size = 10;
    }

    public static Computer[] getComputers() {
        return computers;
    }

    public void turnOn(int number, CustomerAccount customerAccount){
        computers[number].setState(1);
        computers[number].setUser(customerAccount);
    }

    public int size(){
        return size;
    }
}
