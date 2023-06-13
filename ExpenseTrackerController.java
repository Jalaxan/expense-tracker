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
}
