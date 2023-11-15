import java.util.*;
public class IPManager implements TransferController {
    private IPDB DB; // IPDB is THE Instapay Database
    private User currentUser;
    private TransferController TSControler;
    private void displayLoggedOutMenu(){
        System.out.println("1- Signup");
        System.out.println("2- Login");
        System.out.println("3- Exit\n");
    }
    public IPManager(){

        System.out.println("Welcome to INSTA>>PAY");

        this.currentUser = null;

        this.DB = new IPDB();

    }
    public void run(){

        boolean isRunning = true;

        if(this.currentUser == null){ // logged out

            while (isRunning){
                displayLoggedOutMenu();

                System.out.print("Please, Enter Your Option: ");
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();

                switch (option){
                    case 1:
                        signUp();
                        break;

                    case 2:
                        signIn();
                        isRunning = false;
                        break;

                    case 3:
                        System.out.println("\nThank you for using our application");
                        return;

                    default:
                        System.out.println("Invalid Option\n");
                }
            }
        }

        isRunning = true;
        while (isRunning){

            currentUser.displayLoggedInMenu();
            System.out.print("Please, Enter Your Option: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            if(currentUser.getProvider().getproviderType() == "bank"){
                /// a3ml class transactions mas2ool 3n kol dool
                switch (option){
                    case 1:
                        payBills();
                        break;
                    case 2:
                        transferToWallet();
                        break;
                    case 3:
                       transferToIPAcc();
                        break;
                    case 4:
                        transferToBankAcc();
                        break;
                    case 5:
                        System.out.println("Your balance is: " + currentUser.getBalance());
                        break;
                    case 6:
                        currentUser = null;
                        run();
                        isRunning = false;
                        break;
                    default:
                        System.out.println("\nInvalid Option\n");
                }

            }
            else{
                switch (option){
                    case 1:
                        payBills();
                        break;
                    case 2:
                        transferToWallet();
                        break;
                    case 3:
                        transferToIPAcc();
                        break;
                    case 4:
                        currentUser.getBalance();
                        break;
                    case 5:
                        currentUser = null;
                        run();
                        isRunning = false;
                        break;
                    default:
                        System.out.println("\nInvalid Option\n");
                }
            }

        }

    }
    private void signUp(){

        System.out.print("you want to sign up with your bank account (b) or your mobile number with a wallet (w)?");

        Scanner scanner = new Scanner(System.in);
        char choice = scanner.nextLine().charAt(0);

        while(choice != 'b' && choice != 'w'){
            System.out.println("Wrong choice");
            System.out.print("you want to sign up with your bank account (b) or your mobile number with a wallet (w)?");
            choice = scanner.nextLine().charAt(0);
        }

        if(choice == 'b'){

            System.out.print("Enter your bank account: ");
            String bankAcc = scanner.nextLine();

            System.out.print("Enter your phone number: ");
            String phoneNumber = scanner.nextLine();

            /// verify phone number with otp

            System.out.print("Enter your username: ");
            String userName = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            System.out.print("Enter your provider name: ");
            String providerName = scanner.nextLine();
            Provider provider = new WalletProvider(providerName, "bank");

            User newUser = new BankAccount(userName, password, phoneNumber, 0, provider, bankAcc);
            DB.addAccount(newUser);

        }
        else {

            System.out.print("Enter your phone number: ");
            String phoneNumber = scanner.nextLine();

            /// verify phone number with otp

            System.out.print("Enter your username: ");
            String userName = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            System.out.print("Enter your provider name: ");
            String providerName = scanner.nextLine();
            Provider provider = new WalletProvider(providerName, "wallet");

            User newUser = new WalletAccount(userName, password, phoneNumber, 0, provider);
            DB.addAccount(newUser);

        }
    }
    private void signIn(){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();

        while (DB.getAccountByUserName(userName) == null){
            System.out.println("This username isn't connected to an account");
            System.out.print("Enter your username: ");
            userName = scanner.nextLine();
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        while (!Objects.equals(DB.getAccountByUserName(userName).getPassword(), password)){
            System.out.println("The password that you've entered is incorrect");
            System.out.print("Enter your password: ");
            password = scanner.nextLine();
        }

        currentUser = DB.getAccountByUserName(userName);

    }

    private void payBills(){

    }

    @Override
    public void transferToWallet() {

        System.out.print("Enter the phone number you want to transfer to: ");
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine();

        while(DB.getAccountByPhoneNumber(phoneNumber) == null){
            System.out.println("This phone number isn't connected to a wallet");
            return;
        }

        System.out.print("Enter the amount you want to transfer: ");
        double amount = scanner.nextDouble();

        DB.getAccountByPhoneNumber(phoneNumber).getProvider().addBalance(phoneNumber, amount);
        currentUser.setBalance(currentUser.getBalance() - amount);

    }

    @Override
    public void transferToIPAcc() {

        System.out.print("Enter the username you want to transfer to: ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();

        while(DB.getAccountByUserName(userName) == null){
            System.out.println("This username isn't connected to an account");
            return;
        }

        System.out.print("Enter the amount you want to transfer: ");
        double amount = scanner.nextDouble();

        DB.getAccountByUserName(userName).setBalance(DB.getAccountByUserName(userName).getBalance() + amount);
        currentUser.setBalance(currentUser.getBalance() - amount);
    }

    @Override
    public void transferToBankAcc() {
        System.out.print("Enter the bank account you want to transfer to: ");
        Scanner scanner = new Scanner(System.in);
        String bankAcc = scanner.nextLine();

        while(DB.getAccountBybankAccount(bankAcc) == null){
            System.out.println("This bank account isn't right");
            return;
        }

        System.out.print("Enter the amount you want to transfer: ");
        double amount = scanner.nextDouble();

        DB.getAccountBybankAccount(bankAcc).getProvider().addBalance(bankAcc, amount);
        currentUser.setBalance(currentUser.getBalance() - amount);

    }
}
