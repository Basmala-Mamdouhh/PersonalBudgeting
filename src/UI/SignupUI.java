package UI;

import DataBase.UserDB;
import controller.AuthController;

import java.util.Scanner;

public class SignupUI {
    public static void displaymenu(UserDB userDB) {
        AuthController controller = new AuthController(userDB);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        controller.handleSignUp(email, username, password,phone);
    }
}
