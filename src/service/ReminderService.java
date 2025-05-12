package service;

import Domain.Reminder;

import java.util.Date;

public class ReminderService {

    public static boolean isValidReminder( String title, Date date, Date time) {

        if (title == null || title.isBlank()) {
            System.out.println("Title is required.");
            return false;
        }

        if (date == null) {
            System.out.println("Date is required.");
            return false;
        }

        if (time == null) {
            System.out.println("Time is required.");
            return false;
        }
        return true;
    }
}
