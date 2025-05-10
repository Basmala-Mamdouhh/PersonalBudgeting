package UI;

import Domain.Reminder;
import controller.ReminderController;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReminderUI {
    private Scanner scanner = new Scanner(System.in);

    private ReminderController reminderController;
    private List<Reminder> reminderList;

    public ReminderUI(ReminderController controller) {
        this.reminderController = controller;
    }

    public void showDashboard() {
        System.out.println("===== Reminder Dashboard =====");
        System.out.println("1. Add Reminder");
        System.out.println("2. View All Reminders");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addReminder();
                break;
            case 2:
                showReminders(reminderController.getAllReminders());
                break;
            default:
                System.out.println("Exiting...");
        }
    }

    public void addReminder() {
        System.out.print("Enter reminder text: ");
        String text = scanner.nextLine();

        System.out.print("Enter date (yyyy-mm-dd): ");
        String date = scanner.nextLine(); // You can parse this

        System.out.print("Enter time (HH:mm): ");
        String time = scanner.nextLine(); // You can parse this

        Reminder reminder = new Reminder(text, date, time);
        reminderController.addReminder(reminder);
        showConfirmation("Reminder added successfully.");
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
            System.out.println("ID: " + r.getReminderId() + " | Text: " + r.getText() +
                    " | Date: " + r.getDate() + " | Time: " + r.getTime());
        }
    }
}
