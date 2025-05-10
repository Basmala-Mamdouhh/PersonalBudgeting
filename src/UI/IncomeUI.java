package UI;

import DataBase.IncomeDB;
import controller.IncomeController;

import java.util.Scanner;

public class IncomeUI {

    public void AddIncomeUI(int user_id) {
        IncomeDB incomeDB = new IncomeDB();
        IncomeController Income_controller = new IncomeController(incomeDB);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the income source");
        String incomeSource = scanner.nextLine();
        while (true){
            System.out.println("Enter the income value");
            double incomeValue = scanner.nextDouble();
            if(Income_controller.HandleIncome(incomeSource,incomeValue,user_id)){
                break;
            }
        }

    }

    public void displayIncomeUI(int user_id) {
        IncomeDB incomeDB = new IncomeDB();
        IncomeController Income_controller = new IncomeController(incomeDB);
        Income_controller.displayuserIncome(user_id);
    }

    public void Mainmenu(int user_id){
        Scanner scanner = new Scanner(System.in);
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
            }
        }


    }
}
