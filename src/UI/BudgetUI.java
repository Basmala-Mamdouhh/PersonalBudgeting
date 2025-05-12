package UI;

import DataBase.BudgetDB;
import controller.BudgetController;

import java.util.Scanner;

public class BudgetUI {
    private Scanner scanner = new Scanner(System.in);
    private BudgetDB budgetDB = new BudgetDB();
    private BudgetController Budget_controller = new BudgetController(budgetDB);

    public void AddBudgetUI(int user_id) {
        while (true){
            System.out.println("Enter the Budget Category");
            String BudgetCategory = scanner.nextLine();
            System.out.println("Enter the Budget limit");
            double BudgetLimit = scanner.nextDouble();
            scanner.nextLine();
            if(Budget_controller.HandleBudget(BudgetCategory,BudgetLimit,user_id)){
                break;
            }
        }
    }

    public void displayBudgetUI(int user_id) {
        Budget_controller.displayuserbudget(user_id);
    }


    public void Mainmenu(int user_id){
        while(true){
            System.out.println("Welcome to Budget UI");
            System.out.println("1. Add Budget");
            System.out.println("2. view Budgets");
            System.out.println("3. Return to dashboard");
            String choice =scanner.nextLine();
            switch (choice) {
                case "1":
                    AddBudgetUI(user_id);
                    break;
                case "2":
                    displayBudgetUI(user_id);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }


    }
}


