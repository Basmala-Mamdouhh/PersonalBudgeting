package DataBase;

import Domain.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private static final String FILE_PATH = "users.ser";
    private List<User> users;

    public UserDB() {
        loadUsers();
    }

    @SuppressWarnings("unchecked")
    private void loadUsers() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            users = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            users = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            users = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean emailExists(String email) {
        return users.stream().anyMatch(u -> u.getEmail().equalsIgnoreCase(email));
    }

    public boolean usernameExists(String username) {
        return users.stream().anyMatch(u -> u.getUsername().equalsIgnoreCase(username));
    }


    public User findByEmail(String email) {
        return users.stream().filter(u -> u.getEmail().equalsIgnoreCase(email)).findFirst().orElse(null);
    }

    public User findByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().equalsIgnoreCase(username)).findFirst().orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }

    public int getNextId() {
        return users.stream().mapToInt(User::getId).max().orElse(0) + 1;
    }

    public void clearAllUsers() {
        users.clear();
        saveUsers();
        System.out.println("All users have been deleted.");
    }
}
