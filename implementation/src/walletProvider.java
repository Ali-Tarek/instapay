import java.util.ArrayList;
import java.util.Objects;

public class WalletProvider extends Provider {
    public WalletProvider(String providerName, String providerType, Pair<String, Double> accountBalance) {
        super(providerName, providerType,  accountBalance);
    }
    public static double inquireBalance(String phoneNumber){
        // should be some logic here
        return 10000;
    }
}
