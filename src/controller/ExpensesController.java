package controller;

import DataBase.BudgetDB;
import DataBase.ExpenseDB;
import Domain.Budget;
import Domain.Expense;
import service.BudgetService;
import service.ExpenseService;

import java.time.LocalDate;
import java.util.List;

public class ExpensesController {
    private final ExpenseDB expenseDB;
    public ExpensesController(ExpenseDB expensedb) {
        this.expenseDB = expensedb;
    }

    public boolean HandleExpense(String category, double amount, String paymentMethod, LocalDate date, int userId) {
        if(ExpenseService.checkExpense(category,amount,paymentMethod,date,userId)){
            Expense expense = new Expense(category, amount, paymentMethod, date, userId);
            expenseDB.addExpense(expense);
            System.out.println("Expense added successfully");
            return true;
        }
        else{
            System.out.println("Expense not added");
            return false;
        }
    }

    public void DisplayUserExpenses(int user_id) {
        List<Expense> allexpenses = expenseDB.getExpensesByUserId(user_id);
        int count = 1;
        for (Expense expense : allexpenses) {
            System.out.println( count + ") Expense Category: " + expense.getCategory()+
                        ", Expense Amount: " + expense.getAmount() + ", Payment Method: " + expense.getPaymentMethod() + ", Date: " + expense.getDate()) ;
            count++;
        }
    }

}
