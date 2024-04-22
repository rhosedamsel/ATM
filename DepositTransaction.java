import javax.swing.JOptionPane;

class DepositTransaction extends Transaction {
    public DepositTransaction(double amount) {
        super(amount);
    }

    @Override
    public void execute(Account account) {
        account.deposit(amount);
        JOptionPane.showMessageDialog(null, "Deposit successful.");
    }
}