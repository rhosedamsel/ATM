import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(123456, 1000.0);
        ATM atm = new ATM(account);
        SwingUtilities.invokeLater(() -> new ATMGUI(atm));
    }
}