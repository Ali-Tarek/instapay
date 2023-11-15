public class BankAccount extends User {
    String bankAcc;
    public BankAccount(String userName, String password, String phoneNumber, double IPbalance, Provider provider, String bankAcc) {
        super(userName, password, phoneNumber, IPbalance, provider);
        this.bankAcc = bankAcc;
    }
    public String getBankAccount(){
        return bankAcc;
    }
    public void displayLoggedInMenu(){
        System.out.println("1- Pay bills");
        System.out.println("2- Transfer to Wallet using the mobile number");
        System.out.println("3- Transfer to another instapay account");
        System.out.println("4- Transfer to bank account");
        System.out.println("5- Inquire your balance");
        System.out.println("6- Logout\n");
    }

}
