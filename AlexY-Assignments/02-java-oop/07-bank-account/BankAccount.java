import java.util.Random;
public class BankAccount{
    public static int numAccounts = 0;
    public static double totalHoldings = 0;

    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;

    private static String generateId() {
        String accountId = "";
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            accountId += r.nextInt(10);
        }
        return accountId;
    }

    public BankAccount() {
        BankAccount.numAccounts++;
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.accountNumber = BankAccount.generateId();
        System.out.println("Bank Account Number: " + accountNumber);
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public void depositMoney(double amount, String account) {
        if(account.equals("checking"))
            this.checkingBalance += amount;
        else if(account.equals("savings"))
            this.savingsBalance += amount;
        BankAccount.totalHoldings += amount;
    }

    public void withdrawMoney(double amount, String account) {
        boolean success = false;
        if(account.equals("checking")){
            if(this.checkingBalance - amount >= 0){
                success = true;
                this.checkingBalance -= amount;
            }
        }
        else if(account.equals("savings"))
            if(this.savingsBalance - amount >= 0){
                success = true;
                this.savingsBalance -= amount;
            }
        if(success) {
            BankAccount.totalHoldings -= amount;
        }
    }

    public void displayAccountBalance() {
        System.out.println(String.format("Checking: %.2f, Saving: %.2f", this.checkingBalance, this.savingsBalance));
    }

}











