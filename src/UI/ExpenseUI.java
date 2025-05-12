package UI;

import DataBase.ExpenseDB;
import DataBase.IncomeDB;
import controller.ExpensesController;
import controller.IncomeController;

import java.time.LocalDate;
import java.util.Scanner;

public class ExpenseUI {
    Scanner scanner = new Scanner(System.in);
    ExpenseDB expenseDB = new ExpenseDB();
    ExpensesController expensesController = new ExpensesController(expenseDB);
    public void AddExpenseUI(int user_id) {
        while (true){
            System.out.println("Enter the expense Category");
            String ExpenseCategory = scanner.nextLine();
            System.out.println("Enter the expense amount");
            double ExpenseValue = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter the expense payment method");
            String ExpensePayment = scanner.nextLine();
            System.out.println("Enter the expense date (yyyy-MM-dd)");
            String ExpenseDate = scanner.nextLine();
            LocalDate localDate = LocalDate.parse(ExpenseDate);
            if(expensesController.HandleExpense(ExpenseCategory,ExpenseValue,ExpensePayment,localDate,user_id)){
                break;
            }
        }

    }

    public void displayExpenseUI(int user_id) {
        expensesController.DisplayUserExpenses(user_id);
    }

    public void Mainmenu(int user_id){
        while(true){
            System.out.println("Welcome to Expense UI");
            System.out.println("1. Add Expense");
            System.out.println("2. view Expenses");
            System.out.println("3. Return to dashboard");
            String choice =scanner.nextLine();
            switch (choice) {
                case "1":
                    AddExpenseUI(user_id);
                    break;
                case "2":
                    displayExpenseUI(user_id);
                    break;
                case "3":
                    return;
            }
        }

    }






}
