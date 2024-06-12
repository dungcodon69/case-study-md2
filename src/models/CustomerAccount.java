package models;

public class CustomerAccount {
    private String username;
    private String password;
    private double balance;
    private double playTime; //minute
    private long startTime;

    public CustomerAccount(String username, String password, int balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.playTime = balance / 100;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public double getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public CustomerAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public CustomerAccount(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getRemainTime(){
        if (balance <= 0) return 0;
        long playedTime = System.currentTimeMillis() - this.getStartTime();
        long remainTime;
        remainTime = (long) (this.getPlayTime() * 60 * 1000L - playedTime);
        return remainTime;
    }

    public synchronized void updateBalance(int balance){
        this.balance += balance;
        this.playTime = this.balance / 100;
    }
}
