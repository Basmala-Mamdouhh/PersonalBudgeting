package service;

public class AuthService {
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    public static boolean isStrongPassword(String password) {
        return password != null && password.length() >= 8;
    }

    public static boolean isValidUsername(String username) {
        return username != null && username.length() >= 3;
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null) return false;
        String cleaned = phone.replaceAll("[\\s\\-()]", "");
        return cleaned.matches("^\\+?\\d{10,15}$");
    }


}
