package UI;

import DataBase.ReminderDB;
import Domain.Reminder;
import controller.ReminderController;
import service.ReminderService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReminderUI {
    private ReminderDB reminderDB = new ReminderDB();
    private Scanner scanner = new Scanner(System.in);
    private ReminderController reminderController = new ReminderController(reminderDB);

    public ReminderUI() {
    }

    public void mainMenu(int userId) {
        while (true) {
            System.out.println("\n===== Reminder Menu =====");
            System.out.println("1. Add Reminder");
            System.out.println("2. View Reminders");
            System.out.println("3. Return to Dashboard");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addReminder(userId);
                    break;
                case "2":
                    viewReminders(userId);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public void addReminder(int userId) {
        while (true) {
            System.out.print("Enter reminder title: ");
            String title = scanner.nextLine();

            System.out.print("Enter date (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();

            System.out.print("Enter time (HH:mm): ");
            String timeStr = scanner.nextLine();


            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFormat.parse(dateStr);

                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                Date time = timeFormat.parse(timeStr);
                if(reminderController.handleReminder(title, date, time, userId)){
                    break;
                };

            } catch (ParseException e) {
                System.out.println("Invalid date/time format.");
            }
        }

    }

    public void viewReminders(int userId) {
        reminderController.displayUserReminders(userId);
    }
}
