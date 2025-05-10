package DataBase;

import Domain.Reminder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReminderDB {
    private static final String FILE_PATH = "reminders.ser";
    private List<Reminder> reminders;

    public ReminderDB() {
        loadReminders();
    }

    // Load all reminders from file
    @SuppressWarnings("unchecked")
    private void loadReminders() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            reminders = new ArrayList<>();
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            reminders = (List<Reminder>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            reminders = new ArrayList<>();
            e.printStackTrace();
        }
    }

    // Save all reminders to file
    private void saveReminders() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(reminders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Create new reminder for a user
    public void createReminder(int userId, Reminder reminder) {
        reminder.setUserId(userId);
        reminder.setReminderId(getNextReminderId());
        reminders.add(reminder);
        saveReminders();
    }

    // Update a reminder
    public boolean updateReminder(int reminderId, Reminder updatedReminder) {
        for (int i = 0; i < reminders.size(); i++) {
            Reminder r = reminders.get(i);
            if (r.getReminderId() == reminderId) {
                updatedReminder.setReminderId(reminderId);
                updatedReminder.setUserId(r.getUserId()); // Keep user ID
                reminders.set(i, updatedReminder);
                saveReminders();
                return true;
            }
        }
        return false;
    }

    // Return all reminders
    public List<Reminder> fetchAllReminders() {
        return new ArrayList<>(reminders);
    }

    // Return reminders for specific user
    public List<Reminder> fetchRemindersByUser(int userId) {
        return reminders.stream()
                .filter(r -> r.getUserId() == userId)
                .collect(Collectors.toList());
    }

    // Delete reminder by ID
    public boolean deleteReminder(int reminderId) {
        boolean removed = reminders.removeIf(r -> r.getReminderId() == reminderId);
        if (removed) {
            saveReminders();
        }
        return removed;
    }

    // Generate next unique ID
    private int getNextReminderId() {
        return reminders.stream()
                .mapToInt(Reminder::getReminderId)
                .max()
                .orElse(0) + 1;
    }
}
