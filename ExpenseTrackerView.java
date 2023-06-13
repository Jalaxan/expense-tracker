import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseTrackerView extends JPanel {
    private DefaultListModel<String> transactionListModel;
    private JTextField amountTextField;
    private JTextField balanceTextField;
    private JComboBox<String> categoryComboBox;
    private ExpenseTrackerController controller;

    public ExpenseTrackerView() {
        setLayout(new BorderLayout());

        // Create the transaction list and its model
        transactionListModel = new DefaultListModel<>();
        JList<String> transactionList = new JList<>(transactionListModel);
        JScrollPane scrollPane = new JScrollPane(transactionList);
        add(scrollPane, BorderLayout.CENTER);

        // Create the panel for adding transactions
        JPanel transactionPanel = new JPanel(new FlowLayout());

        JLabel amountLabel = new JLabel("Amount:");
        amountTextField = new JTextField(15);

        JLabel categoryLabel = new JLabel("Category:");
        String[] categories = {"Income", "Food", "Transportation", "Entertainment", "Shopping", "Others"};
        categoryComboBox = new JComboBox<>(categories);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.addTransaction();
            }
        });


    }}