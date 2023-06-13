import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseTrackerModel {
    private ExpenseTrackerDatabase database;

    public ExpenseTrackerModel() {
        database = new ExpenseTrackerDatabase();
    }

    public void addExpense(double amount, String category) {
        database.addTransaction(-amount, category);
    }

    public void addIncome(double amount) {
        database.addTransaction(amount, "Income");
    }

    public double getWalletBalance() {
        ResultSet resultSet = database.getAllTransactions();
        double balance = 0;

        try {
            while (resultSet.next()) {
                double amount = resultSet.getDouble("amount");
                balance += amount;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return balance;
    }
}