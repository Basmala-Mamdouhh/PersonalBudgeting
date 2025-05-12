package controller;

import DataBase.ReminderDB;
import Domain.Reminder;
import service.ReminderService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReminderController {
    private final ReminderDB reminderDB;

    public ReminderController(ReminderDB reminderDB) {
        this.reminderDB = reminderDB;
    }

    public boolean handleReminder(String title, Date date, Date time, int userId) {
        if(ReminderService.isValidReminder(title,date,time)){
            Reminder reminder = new Reminder(userId, title, date, time);
            reminderDB.addReminder(reminder);
            System.out.println("Reminder saved successfully.");
            return true;
        }
        else{
            System.out.println("Reminder not added");
            return false;
        }

    }

    public void displayUserReminders(int userId) {
        List<Reminder> reminders = reminderDB.getRemindersByUserId(userId);
        if (reminders.isEmpty()) {
            System.out.println("No reminders found for user ID: " + userId);
            return;
        }
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int count = 1;
        for (Reminder reminder : reminders) {
            System.out.println(count + ") Title: " + reminder.getTitle() +
                    ", Date: " + dateFormat.format(reminder.getDate()) +
                    ", Time: " + timeFormat.format(reminder.getTime()));
            count++;
        }
    }
}
