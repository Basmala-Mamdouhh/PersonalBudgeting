package service;

import Domain.Reminder;

public class ReminderService {

    public boolean isValidReminder(Reminder reminder) {
        if (reminder == null) {
            System.out.println("Reminder cannot be null.");
            return false;
        }

        if (reminder.getTitle() == null || reminder.getTitle().isBlank()) {
            System.out.println("Title is required.");
            return false;
        }

        if (reminder.getDate() == null) {
            System.out.println("Date is required.");
            return false;
        }

        if (reminder.getTime() == null) {
            System.out.println("Time is required.");
            return false;
        }

        return true;
    }
}
