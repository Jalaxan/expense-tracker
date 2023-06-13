import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ExpenseTrackerModel model = new ExpenseTrackerModel();
        ExpenseTrackerView view = new ExpenseTrackerView();
        ExpenseTrackerController controller = new ExpenseTrackerController(model, view);

        view.setController(controller);

        JFrame frame = new JFrame("Expense Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 400);
        frame.getContentPane().add(view);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}