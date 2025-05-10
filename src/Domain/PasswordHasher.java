package Domain;

public class PasswordHasher {
    public static String hash(String password) {
        return Integer.toHexString(password.hashCode());
    }
}
