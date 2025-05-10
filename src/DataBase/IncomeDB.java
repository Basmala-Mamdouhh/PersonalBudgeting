package DataBase;

import model.Income;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IncomeDB {
    private static final String FILE_PATH = "incomes.ser";
    private List<Income> incomes;

    public IncomeDB() {
        loadIncomes();
    }

    private void loadIncomes() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            incomes = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            incomes = (List<Income>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            incomes = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private void saveIncomes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(incomes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addIncome(Income income) {
        incomes.add(income);
        saveIncomes();
    }

    public List<Income> getAllIncomes() {
        return new ArrayList<>(incomes);
    }

    public List<Income> getIncomesByUserId(int userId) {
        return incomes.stream()
                .filter(income -> income.getUserId() == userId)
                .collect(Collectors.toList());

    }

    public void clearAllIncomes() {
        incomes.clear();
        saveIncomes();
        System.out.println("All income records have been deleted.");
    }
}
