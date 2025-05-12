package DataBase;

import Domain.Budget;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BudgetDB {
    private static final String FILE_PATH = "budgets.ser";
    private List<Budget> budgets;

    public BudgetDB() {
        loadBudgets();
    }

    @SuppressWarnings("unchecked")
    private void loadBudgets() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            budgets = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            budgets = (List<Budget>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            budgets = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private void saveBudgets() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(budgets);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBudget(Budget budget) {
        budgets.add(budget);
        saveBudgets();
    }

    public List<Budget> getBudgetsByUserId(int userId) {
        return budgets.stream()
                .filter(budget -> budget.getUserId() == userId)
                .collect(Collectors.toList());
    }

}