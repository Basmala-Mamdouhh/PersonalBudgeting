package service;

import DataBase.ReminderDB;
import Domain.Reminder;

import java.util.List;

public class ReminderService {
    private final ReminderDB reminderDB;

    public ReminderService(ReminderDB reminderDB) {
        this.reminderDB = reminderDB;
    }

    public void addReminder(int userId, Reminder reminder) {
        reminderDB.createReminder(userId, reminder);
        System.out.println("Reminder added successfully.");
    }

    public void updateReminder(int userId, Reminder reminder) {
        Reminder existing = reminderDB.fetchRemindersByUser(userId).stream()
                .filter(r -> r.getReminderId() == reminder.getReminderId())
                .findFirst()
                .orElse(null);

        if (existing != null) {
            reminder.setUserId(userId); // keep user ID
            reminderDB.updateReminder(reminder.getReminderId(), reminder);
            System.out.println("Reminder updated successfully.");
        } else {
            System.out.println("Reminder not found for this user.");
        }
    }

    public List<Reminder> getRemindersForUser(int userId) {
        return reminderDB.fetchRemindersByUser(userId);
    }

    public boolean deleteReminder(int reminderId) {
        return reminderDB.deleteReminder(reminderId);
    }

    public void scheduleNotification(Reminder reminder) {
        // You can enhance this method to schedule future alerts using a timer
        System.out.println("Notification scheduled for: " + reminder.getDate() + " at " + reminder.getTime());
    }
}
