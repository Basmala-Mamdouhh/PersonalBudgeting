package model;

import java.io.Serializable;

public class Income implements Serializable {
    private String incomeSource;
    private double incomeAmount;
    private int userId;

    public Income(String incomeSource, double incomeAmount, int userId) {
        this.incomeSource = incomeSource;
        this.incomeAmount = incomeAmount;
        this.userId = userId;
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    public double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
