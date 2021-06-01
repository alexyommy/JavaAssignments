public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount me = new BankAccount();
        me.depositMoney(100, "checking");
        me.displayAccountBalance();
        System.out.println(BankAccount.totalHoldings);

    }
}



