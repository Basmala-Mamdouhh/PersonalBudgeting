package controller;

import DataBase.IncomeDB;
import DataBase.UserDB;
import Domain.Income;
import service.IncomeService;

import java.util.List;

public class IncomeController {
    private final IncomeDB incomeDB;

    public IncomeController(IncomeDB incomedb) {
        this.incomeDB = incomedb;
    }

    public boolean HandleIncome(String income_source , double income_amount , int user_id) {
        if(IncomeService.isvalidAmount(income_amount)) {
            Income income = new Income(income_source, income_amount, user_id);
            incomeDB.addIncome(income);
            System.out.println("Income saved successfully.");
            return true;
        }
        else{
            System.out.println("Invalid,income amount entered.");
            return false;
        }
    }

    public void displayuserIncome(int user_id) {
        List<Income>  allIncomes = incomeDB.getIncomesByUserId(user_id);
        int count = 1;
        for (Income income : allIncomes) {
            System.out.println( count + ") Source: " + income.getIncomeSource() +
                    ", Amount: " + income.getIncomeAmount());
            count++;
        }
    }
}
