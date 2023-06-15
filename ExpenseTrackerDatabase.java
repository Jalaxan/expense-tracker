import java.sql.*;

public class ExpenseTrackerDatabase {
    private static final String DATABASE_URL = "jdbc:sqlite:expense_tracker.db";
    private Connection connection;

    public ExpenseTrackerDatabase() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL);
            createTableIfNotExists();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists() throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS transactions (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "amount REAL NOT NULL," +
                "category TEXT NOT NULL," +
                "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
        }
    }

    public void addTransaction(double amount, String category) {
        String insertSQL = "INSERT INTO transactions (amount, category) VALUES (?, ?);";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, category);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllTransactions() {
        String selectSQL = "SELECT amount, category FROM transactions ORDER BY timestamp DESC;";

        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(selectSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
