package service;

import model.User;
import DataBase.UserDB;
import model.PasswordHasher;

public class LoginService {
    private final UserDB userRepository;

    public LoginService(UserDB userRepository) {
        this.userRepository = userRepository;
    }

    public String login(String username, String password) {
        if (!AuthService.isValidUsername(username)) return "Invalid username format.";
        if (!AuthService.isStrongPassword(password)) return "Invalid password format.";

        User user = userRepository.findByUsername(username);
        if (user == null || !user.isActive()) {
            return "Invalid credentials or user does not exist.";
        }
        String hashedInput = PasswordHasher.hash(password);
        if (!user.getPasswordHash().equals(hashedInput)) {
            return "Incorrect password.";
        }
        return "Login successful. Welcome " + user.getUsername() + "!";
    }
}
