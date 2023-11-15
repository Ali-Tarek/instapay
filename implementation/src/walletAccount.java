public class WalletAccount extends User {
    public WalletAccount(String userName, String password, String phoneNumber, double IPbalance, Provider provider) {
        super(userName, password, phoneNumber, IPbalance, provider);
    }
    public void displayLoggedInMenu(){
        System.out.println("1- Pay bills");
        System.out.println("2- Transfer to Wallet using the mobile number");
        System.out.println("3- Transfer to Another instapay account");
        System.out.println("4- Inquire your balance");
        System.out.println("5- Logout\n");
    }

}
