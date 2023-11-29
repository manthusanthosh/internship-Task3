import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Expense {
    private String description;
    private double amount;
    private String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}

class ExpenseTracker {
    private List<Expense> expenses;
    private Map<String, Double> categoryTotals;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
        categoryTotals = new HashMap<>();
    }

    public void addExpense(String description, double amount, String category) {
        Expense newExpense = new Expense(description, amount, category);
        expenses.add(newExpense);

        double total = categoryTotals.getOrDefault(category, 0.0);
        categoryTotals.put(category, total + amount);
    }

    public void displayExpenses() {
        System.out.println("---- Expenses ----");
        for (Expense expense : expenses) {
            System.out.println("Description: " + expense.getDescription()
                    + ", Amount: " + expense.getAmount()
                    + ", Category: " + expense.getCategory());
        }
    }

    public void displayExpenseSummaries() {
        System.out.println("---- Expense Summaries ----");
        for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
            System.out.println("Category: " + entry.getKey() + ", Total Amount: " + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. View Expense Summaries");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // consume the newline character
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();

                    tracker.addExpense(description, amount, category);
                    System.out.println("Expense added successfully!\n");
                    break;
                case 2:
                    tracker.displayExpenses();
                    System.out.println();
                    break;
                case 3:
                    tracker.displayExpenseSummaries();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.\n");
            }
        }
    }
}
