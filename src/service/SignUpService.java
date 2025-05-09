package service;

import model.User;
import DataBase.UserDB;
import model.PasswordHasher;

public class SignUpService {
    private final UserDB userDB;

    public SignUpService(UserDB userRepository) {
        this.userDB = userRepository;
    }

    public String register(String email, String username, String password, String phone) {
        if (!AuthService.isValidEmail(email)) return "Invalid email.";
        if (!AuthService.isStrongPassword(password)) return "Weak password.";
        if (!AuthService.isValidUsername(username)) return "Invalid username.";
        if (!AuthService.isValidPhone(phone)) return "Invalid phone number.";

        if (userDB.emailExists(email)) return "Email already exists.";
        if (userDB.usernameExists(username)) return "Username already exists.";

        int id = userDB.getNextId();
        String hashed = PasswordHasher.hash(password);
        User user = new User(id, email, username, hashed, phone);
        userDB.addUser(user);
        return "Account created successfully.";
    }
}