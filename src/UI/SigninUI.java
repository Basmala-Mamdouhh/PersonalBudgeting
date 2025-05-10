package UI;
import DataBase.UserDB;
import controller.UserController;

import java.util.Scanner;

public class SigninUI {
    public static void viewsigninUI(UserDB userDB){
        UserController controller = new UserController(userDB);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String loginEmail = scanner.nextLine();
        System.out.print("Enter Password: ");
        String loginPassword = scanner.nextLine();
        controller.handleLogin(loginEmail, loginPassword);
    }
}
