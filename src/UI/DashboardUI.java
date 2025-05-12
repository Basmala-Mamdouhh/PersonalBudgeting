package UI;

import DataBase.ReminderDB;
import controller.ReminderController;
import service.ReminderService;

import java.util.Scanner;

public class DashboardUI {

    public static void viewdashboard(String username , int user_id) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Budgeting Dashboard =====");
            System.out.println("Welcome, " + username + "!");
            System.out.println("1. Tracking Income");
            System.out.println("2. Expense Tracking");
            System.out.println("3. Budgeting & Analysis");
            System.out.println("4. Reminders");
            System.out.println("5. Exit");
            String choice = scanner.nextLine();
            if(choice.equals("1")) {
                IncomeUI Income_UI = new IncomeUI();
                Income_UI.Mainmenu(user_id);
            }
            else if(choice.equals("2")) {
                ExpenseUI expenseUI = new ExpenseUI();
                expenseUI.Mainmenu(user_id);
            }
            else if(choice.equals("3")) {
                BudgetUI budgetUI = new BudgetUI();
                budgetUI.Mainmenu(user_id);
            }
            else if(choice.equals("4")) {
                ReminderDB reminderdb = new ReminderDB();
                ReminderController reminderController = new ReminderController(reminderdb);
                ReminderService reminderService = new ReminderService();
                ReminderUI reminderui = new ReminderUI(reminderController,reminderService);
                reminderui.mainMenu(user_id);
            }
            else if(choice.equals("5")) {
                System.exit(0);
            }
        }
    }
}
