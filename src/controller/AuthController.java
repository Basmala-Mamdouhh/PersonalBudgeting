package controller;

import service.AuthService;
import DataBase.UserDB;
import Domain.User;
import Domain.PasswordHasher;

public class AuthController {
    private final UserDB userDB;

    public AuthController(UserDB userDB) {
        this.userDB = userDB;
    }

    public void handleSignUp(String email, String username, String password, String phone) {
        if (!AuthService.isValidEmail(email)) {
            System.out.println("Invalid email format.");
            return;
        }
        if (!AuthService.isStrongPassword(password)) {
            System.out.println("Weak password.");
            return;
        }

        if(!AuthService.isValidPhone(phone)) {
            System.out.println("Invalid phone number.");
            return;
        }

        if (userDB.emailExists(email)) {
            System.out.println("Email already exists.");
            return;
        }
        if (userDB.usernameExists(username)) {
            System.out.println("Username already exists.");
            return;
        }

        int id = userDB.getNextId();
        String hashed = PasswordHasher.hash(password);
        User user = new User(id, email, username,phone, hashed);
        userDB.addUser(user);
        System.out.println("Account created successfully.");
    }

    public void handleLogin(String email, String password) {
        User user = userDB.findByEmail(email);
        if (user == null) {
            System.out.println("Invalid credentials or user does not exist.");
            return;
        }

        if (!user.getPasswordHash().equals(PasswordHasher.hash(password))) {
            System.out.println("Invalid password.");
            return;
        }
        System.out.println("Login successful. Welcome, " + user.getUsername());
    }
}
