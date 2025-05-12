package service;

import java.util.List;

public class BudgetService {
    public static boolean checkBudget(String category, double amount, int userId) {
        if (category == null || category.length() < 3 || category.length() > 50) {
            System.out.println("Invalid category name.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Amount must be a positive number.");
            return false;
        }
        return true;
    }
}
