package service;

import DataBase.ExpenseDB;
import Domain.Expense;

import java.time.LocalDate;
import java.util.List;

public class ExpenseService {
    private final ExpenseDB expenseDB;

    public ExpenseService(ExpenseDB expenseDB) {
        this.expenseDB = expenseDB;
    }

    public String addExpense(String category, double amount, String paymentMethod, LocalDate date, int userId) {
        if (category == null || category.length() < 3 || category.length() > 50) {
            return "Invalid category name.";
        }
        if (amount <= 0) {
            return "Amount must be positive.";
        }
        if (date == null || date.isAfter(LocalDate.now().plusYears(10))) {
            return "Invalid date.";
        }

        Expense expense = new Expense(category, amount, paymentMethod, date, userId);
        expenseDB.addExpense(expense);
        return "Expense added successfully.";
    }

    public List<Expense> getUserExpenses(int userId) {
        return expenseDB.getExpensesByUserId(userId);
    }
}