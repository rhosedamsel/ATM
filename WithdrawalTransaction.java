import javax.swing.JOptionPane;

class WithdrawalTransaction extends Transaction {
    public WithdrawalTransaction(double amount) {
        super(amount);
    }

    @Override
    public void execute(Account account) {
        if (account.withdraw(amount)) {
            JOptionPane.showMessageDialog(null, "Withdrawal successful.");
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient funds.");
        }
    }
}