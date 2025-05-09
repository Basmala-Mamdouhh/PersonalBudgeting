package service;

import model.User;
import DataBase.UserDB;
import model.PasswordHasher;

public class SignUpService {
    private final UserDB userRepository;

    public SignUpService(UserDB userRepository) {
        this.userRepository = userRepository;
    }

    public String register(String email, String username, String password) {
        if (!AuthService.isValidEmail(email)) return "Invalid email format.";
        if (!AuthService.isValidUsername(username)) return "Username must be at least 3 characters.";
        if (!AuthService.isStrongPassword(password)) return "Password too weak.";

        if (userRepository.emailExists(email)) {
            User existingUser = userRepository.findByEmail(email);
            if (!existingUser.isActive()) {
                return "This user was previously deleted.";
            }
            return "Email is already in use.";
        }
        if (userRepository.usernameExists(username)) {
            return "Username is already in use.";
        }

        int id = userRepository.getNextId();
        String hashed = PasswordHasher.hash(password);
        User user = new User(id, email, username, hashed);
        userRepository.addUser(user);
        return "Account created successfully.";
    }
}