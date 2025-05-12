package DataBase;

import Domain.Expense;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseDB {
    private static final String FILE_PATH = "expenses.ser";
    private List<Expense> expenses;

    public ExpenseDB() {
        loadExpenses();
    }

    @SuppressWarnings("unchecked")
    private void loadExpenses() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            expenses = new ArrayList<>();
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            expenses = (List<Expense>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            expenses = new ArrayList<>();
            e.printStackTrace();
        }
    }

    private void saveExpenses() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(expenses);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveExpenses();
    }


    public List<Expense> getExpensesByUserId(int userId) {
        return expenses.stream()
                .filter(expense -> expense.getUserId() == userId)
                .collect(Collectors.toList());
    }

}