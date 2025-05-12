package controller;

import DataBase.BudgetDB;
import DataBase.IncomeDB;
import Domain.Budget;
import Domain.Income;
import service.BudgetService;

import java.util.List;

public class BudgetController {
    private final BudgetDB budgetDB;

    public BudgetController(BudgetDB budgetdb) {
        this.budgetDB = budgetdb;
    }

    public boolean HandleBudget(String category, double amount, int userId) {
        if(BudgetService.checkBudget(category,amount,userId)){
            Budget budget = new Budget(category, amount, userId);
            budgetDB.addBudget(budget);
            System.out.println("Budget added successfully");
            return true;
        }
        else{
            System.out.println("Budget not added");
            return false;
        }
    }

    public void displayuserbudget(int user_id) {
        List<Budget> allbudgets = budgetDB.getBudgetsByUserId(user_id);
        int count = 1;
        for (Budget budget : allbudgets) {
            System.out.println( count + ") Budget Category: " + budget.getCategory()+
                    ", Budget Limit: " + budget.getAmount());
            count++;
        }
    }
}
