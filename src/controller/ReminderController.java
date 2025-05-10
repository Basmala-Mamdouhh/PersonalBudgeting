package controller;

import Domain.Reminder;
import service.ReminderService;

import java.util.List;

public class ReminderController {
    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    public void addReminder(int userId, Reminder reminder) {
        reminderService.addReminder(userId, reminder);
        System.out.println("Reminder added successfully.");
    }

    public List<Reminder> getAllReminders() {
        return reminderService.getAllReminders();
    }

    public void updateReminder(int userId, Reminder reminder) {
        boolean success = reminderService.updateReminder(userId, reminder);
        if (success) {
            System.out.println("Reminder updated successfully.");
        } else {
            System.out.println("Reminder update failed.");
        }
    }
}
