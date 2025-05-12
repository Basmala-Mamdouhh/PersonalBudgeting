package service;

import DataBase.ExpenseDB;
import Domain.Expense;

import java.time.LocalDate;
import java.util.List;

public class ExpenseService {

    public static boolean checkExpense(String category, double amount, String paymentMethod, LocalDate date, int userId) {
        if (category == null || category.length() < 3 || category.length() > 50) {
            System.out.println("Invalid category name.");
            return false;
        }
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return false;
        }
        if (date == null || date.isAfter(LocalDate.now().plusYears(10))) {
            System.out.println("Invalid date.");
            return false;
        }
        return true;
    }


}