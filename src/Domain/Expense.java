package Domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Expense implements Serializable {
    private String category;
    private double amount;
    private String paymentMethod;
    private LocalDate date;
    private int userId;

    public Expense(String category, double amount, String paymentMethod, LocalDate date, int userId) {
        this.category = category;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.date = date;
        this.userId = userId;
    }

    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public LocalDate getDate() { return date; }
    public int getUserId() { return userId; }
}
