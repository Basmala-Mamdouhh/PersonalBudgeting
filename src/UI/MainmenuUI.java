package UI;

import DataBase.UserDB;
import controller.AuthController;

import java.util.Scanner;

public class MainmenuUI {

    public static  void displayMenu() {
        UserDB userDB = new UserDB();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Welcome to Budgeting App =====");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();
            if(choice.equals("1")) {
                SignupUI.displaymenu(userDB);
            }
            else if(choice.equals("2")) {
                SigninUI.viewsigninUI(userDB);
            }
            else if(choice.equals("3")) {
                System.exit(0);
            }
            else {
                System.out.println("Invalid Choice");
            }

        }

    }
}
