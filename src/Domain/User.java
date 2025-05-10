package Domain;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String email;
    private String username;
    private String phoneNumber;
    private String passwordHash;
    private boolean active;
    private List<Reminder> reminders = new ArrayList<>();


//    public void addReminder(Reminder reminder) {
//        reminders.add(reminder);
//    }
//
//    public void removeReminder(int reminderId) {
//        reminders.removeIf(r -> r.getReminderId() == reminderId);
//    }

    public User(int id, String email, String username, String phoneNumber,String passwordHash) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.passwordHash = passwordHash;
        this.active = true;
    }

    public int getId() { return id; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
    public String getPasswordHash() { return passwordHash; }
    public String getPhoneNumber() { return phoneNumber; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
    public List<Reminder> getReminders() {
        return reminders;
    }
}