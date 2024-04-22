import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ATMGUI extends JFrame implements ActionListener {
    private ATM atm;
    private JTextField pinField, amountField;
    private JButton checkBalanceButton, depositButton, withdrawButton;
    private JLabel insertCardLabel;

    public ATMGUI(ATM atm) {
        super("ATM Machine");
        this.atm = atm;

        // Create components
        JLabel pinLabel = new JLabel("PIN:");
        pinField = new JPasswordField(10); 
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);
        checkBalanceButton = new JButton("Check Balance");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        insertCardLabel = new JLabel("Please insert your ATM card");

        // Add action listeners
        checkBalanceButton.addActionListener(this);
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        // Set layout
        setLayout(new GridLayout(6, 2));

        // Add components to the frame
        add(insertCardLabel);
        add(new JLabel()); // Empty cell for spacing
        add(pinLabel);
        add(pinField);
        add(amountLabel);
        add(amountField);
        add(checkBalanceButton);
        add(depositButton);
        add(withdrawButton);
        add(new JLabel()); // Empty cell for spacing

        // Set frame properties
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String enteredPin = pinField.getText();
        if (enteredPin != "1234") {
            JOptionPane.showMessageDialog(this, "Invalid PIN. Please try again.");
            return;
        }

        if (e.getSource() == checkBalanceButton) {
            JOptionPane.showMessageDialog(this, "Your balance is: $" + atm.checkBalance());
        } else {
            double amount = Double.parseDouble(amountField.getText());

            if (e.getSource() == depositButton) {
                Transaction depositTransaction = new DepositTransaction(amount);
                atm.executeTransaction(depositTransaction);
            } else if (e.getSource() == withdrawButton) {
                Transaction withdrawalTransaction = new WithdrawalTransaction(amount);
                atm.executeTransaction(withdrawalTransaction);
            }
        }
    }
}