package UI;

import DataBase.IncomeDB;
import controller.IncomeController;

import java.util.Scanner;

public class IncomeUI {
    private IncomeDB incomeDB = new IncomeDB();
    private IncomeController Income_controller = new IncomeController(incomeDB);
    private Scanner scanner = new Scanner(System.in);

    public void AddIncomeUI(int user_id) {
        System.out.println("Enter the income source");
        String incomeSource = scanner.nextLine();
        while (true){
            System.out.println("Enter the income value");
            double incomeValue = scanner.nextDouble();
            scanner.nextLine();
            if(Income_controller.HandleIncome(incomeSource,incomeValue,user_id)){
                break;
            }
        }

    }

    public void displayIncomeUI(int user_id) {
        Income_controller.displayuserIncome(user_id);
    }

    public void Mainmenu(int user_id){
        while(true){
            System.out.println("Welcome to Income UI");
            System.out.println("1. Add Income");
            System.out.println("2. view Income");
            System.out.println("3. Return to dashboard");
            String choice =scanner.nextLine();
            switch (choice) {
                case "1":
                    AddIncomeUI(user_id);
                    break;
                case "2":
                    displayIncomeUI(user_id);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}
