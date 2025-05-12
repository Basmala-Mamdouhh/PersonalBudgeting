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

    private void saveReminders() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(reminders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addReminder(Reminder reminder) {
        reminders.add(reminder);
        saveReminders();
    }


    public List<Reminder> getRemindersByUserId(int userId) {
        return reminders.stream()
                .filter(r -> r.getUserId() == userId)
                .collect(Collectors.toList());
    }

}
