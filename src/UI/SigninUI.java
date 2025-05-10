package UI;
import DataBase.UserDB;
import controller.AuthController;

import java.util.Scanner;

public class SigninUI {
    public static void viewsigninUI(UserDB userDB){
        AuthController controller = new AuthController(userDB);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String loginEmail = scanner.nextLine();
        System.out.print("Enter Password: ");
        String loginPassword = scanner.nextLine();
        controller.handleLogin(loginEmail, loginPassword);
    }
}
