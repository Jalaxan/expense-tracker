public class ExpenseTrackerController {
    private ExpenseTrackerModel model;
    private ExpenseTrackerView view;

    public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view) {
        this.model = model;
        this.view = view;
    }

    public void addTransaction() {
        String category = view.getCategory();
        double amount = view.getAmount();

        view.getBalanceTextField().setText(Double.toString(model.getWalletBalance()));

        if (amount > 0) {
            if (category.equals("Income")) {
                model.addIncome(amount);
            } else {
                model.addExpense(amount, category);
            }

            String transaction = String.format("%.2f - %s", amount, category);
            view.addTransaction(transaction);
            view.updateBalance(model.getWalletBalance());

            view.getAmountTextField().setText("");
        }
    }
    public void setController(ExpenseTrackerController controller) {
        this.controller = controller;
    }

    public double getAmount() {
        String amountText = amountTextField.getText();
        if (!amountText.isEmpty()) {
            return Double.parseDouble(amountText);
        }
        return 0.0;
    }

    public String getCategory() {
        return (String) categoryComboBox.getSelectedItem();
    }

    public JTextField getBalanceTextField() {
        return balanceTextField;
    }

    public void addTransaction(String transaction) {
        transactionListModel.addElement(transaction);
    }

    public void updateBalance(double balance) {
        balanceTextField.setText(String.format("%.2f", balance));
    }

    public JTextField getAmountTextField() {
        return amountTextField;
    }
}

