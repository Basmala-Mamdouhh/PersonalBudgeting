package UI;

import Domain.Reminder;
import controller.ReminderController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReminderUI {
    private final Scanner scanner = new Scanner(System.in);
    private final ReminderController reminderController;

    public ReminderUI(ReminderController controller) {
        this.reminderController = controller;
    }

    public void showDashboard() {
        System.out.println("===== Reminder Dashboard =====");
        System.out.print("Enter your User ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        while (true) {
            System.out.println("\n1. Add Reminder");
            System.out.println("2. View My Reminders");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addReminder(userId);
                case 2 -> showReminders(reminderController.getRemindersForUser(userId));
                case 3 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public void addReminder(int userId) {
        try {
            System.out.print("Enter reminder title: ");
            String title = scanner.nextLine();

            System.out.print("Enter date (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();

            System.out.print("Enter time (HH:mm): ");
            String timeStr = scanner.nextLine();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            Date date = dateFormat.parse(dateStr);
            Date time = timeFormat.parse(timeStr);

            Reminder reminder = new Reminder(0, userId, title, date, time);
            reminderController.addReminder(userId, reminder);
            reminderController.scheduleNotification(reminder);
            showConfirmation("Reminder added successfully.");

        } catch (ParseException e) {
            System.out.println("❌ Invalid date or time format. Please try again.");
        }
    }

    public void showConfirmation(String msg) {
        System.out.println("✅ " + msg);
    }

    public void showReminders(List<Reminder> list) {
        System.out.println("===== Your Reminders =====");
        if (list.isEmpty()) {
            System.out.println("No reminders found.");
            return;
        }
        for (Reminder r : list) {
            System.out.println("ID: " + r.getReminderId() +
                    " | Title: " + r.getTitle() +
                    " | Date: " + r.getDate() +
                    " | Time: " + r.getTime() +
                    " | Notified: " + r.isNotified());
        }
    }
}
