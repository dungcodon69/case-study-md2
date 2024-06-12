package models;

import java.time.LocalDateTime;

public class PaymentHistory {
    private LocalDateTime date;
    private String username;
    private int productId;
    private int quantity;
    private double moneyRecharge;
    private double totalAmount;

    public PaymentHistory(LocalDateTime date, String username, int productId, int quantity,double price, double moneyRecharge) {
        this.date = date;
        this.username = username;
        this.productId = productId;
        this.quantity = quantity;
        this.moneyRecharge = moneyRecharge;
        this.totalAmount = (price * quantity) + moneyRecharge;
    }

    public PaymentHistory(LocalDateTime date, String username, int productId, int quantity,double price) {
        this.date = date;
        this.username = username;
        this.productId = productId;
        this.quantity = quantity;
        this.totalAmount = price * quantity;
    }

    public PaymentHistory(LocalDateTime date, double moneyRecharge) {
        this.date = date;
        this.moneyRecharge = moneyRecharge;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getMoneyRecharge() {
        return moneyRecharge;
    }

    public void setMoneyRecharge(double moneyRecharge) {
        this.moneyRecharge = moneyRecharge;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return this.getDate()+","+this.getUsername()+","+this.getProductId()+","+this.getQuantity()+","+this.getMoneyRecharge()+","+this.getTotalAmount();
    }
}
