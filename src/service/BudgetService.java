package service;

import DataBase.BudgetDB;
import Domain.Budget;

import java.util.List;

public class BudgetService {
    private final BudgetDB budgetDB;

    public BudgetService() {
        this.budgetDB = new BudgetDB();
    }

    public String createBudget(String category, double amount, int userId) {
        if (category == null || category.length() < 3 || category.length() > 50) {
            return "Invalid category name.";
        }
        if (amount <= 0) {
            return "Amount must be a positive number.";
        }
        Budget budget = new Budget(category, amount, userId);
        budgetDB.addBudget(budget);
        return "Budget created successfully.";
    }

    public List<Budget> getBudgetsForUser(int userId) {
        return budgetDB.getBudgetsByUserId(userId);
    }
}
