package Domain;

import java.io.Serializable;

public class Budget implements Serializable {
    private String category;
    private double amount;
    private int userId;

    public Budget(String category, double amount, int userId) {
        this.category = category;
        this.amount = amount;
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
