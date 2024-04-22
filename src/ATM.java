class ATM {
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public double checkBalance() {
        return account.getBalance();
    }

    public void executeTransaction(Transaction transaction) {
        transaction.execute(account);
    }
}