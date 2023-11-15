public class User {
    private String userName;
    private String password;
    private String phoneNumber;
    private double balance;
    private Provider provider;
    private Bill bill;
    
    public User(String userName, String password, String phoneNumber, double balance, Provider provider){
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.provider = provider;
        this.bill = new Bill();
    }
    public void displayLoggedInMenu(){}
    public Bill getBill() {
        return bill;
    }
    public void setBill(Bill bill) {
        this.bill = bill;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getBankAccount() {
        return null;
    }
}
