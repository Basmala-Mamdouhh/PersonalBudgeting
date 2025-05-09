package controller;

import DataBase.UserDB;
import service.LoginService;
import service.SignUpService;

public class UserController {
    private final SignUpService signUpService;
    private final LoginService loginService;

    public UserController() {
        UserDB userRepository = new UserDB();
        this.signUpService = new SignUpService(userRepository);
        this.loginService = new LoginService(userRepository);
    }

    public void handleSignUp(String email, String username, String password) {
        String result = signUpService.register(email, username, password);
        System.out.println(result);
    }

    public void handleLogin(String username, String password) {
        String result = loginService.login(username, password);
        System.out.println(result);
    }
}
