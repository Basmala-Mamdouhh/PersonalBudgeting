import controller.UserController;
import DataBase.UserDB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDB sharedDB = new UserDB(); // ✅ Shared database instance
        UserController controller = new UserController(sharedDB);

        boolean running = true;

        while (running) {
            System.out.println("\n===== Welcome to Budgeting App =====");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("4. Clear All Users");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    controller.handleSignUp(email, username, password,phone);
                    break;

                case "2":
                    System.out.print("Enter Email: ");
                    String loginEmail = scanner.nextLine();
                    System.out.print("Enter Password: ");
                    String loginPassword = scanner.nextLine();
                    controller.handleLogin(loginEmail, loginPassword);
                    break;

                case "3":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                case "4":
                    sharedDB.clearAllUsers();
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}