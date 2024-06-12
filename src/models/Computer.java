package models;

public class Computer {
    private int number;
    private int state;
    private CustomerAccount user;


    public Computer(int number, int state, CustomerAccount user) {
        this.number = number;
        this.state = state;
        this.user = user;
    }

    public Computer(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public CustomerAccount getUser() {
        return user;
    }

    public void setUser(CustomerAccount user) {
        this.user = user;
    }

    @Override
    public String toString() {
        if (user != null){
            return "Computer{" +
                    "number=" + number +
                    ", state=" + state +
                    ", user=" + user.getUsername() +
                    '}';
        }
        return "Computer{" +
                "number=" + number +
                ", state=" + state +
                ", user=" + "Not Active" +
                '}';

    }
}
