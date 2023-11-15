import java.util.ArrayList;
import java.util.Objects;

public class WalletProvider extends Provider {
    public WalletProvider(String providerName, String providerType) {
        super(providerName, providerType);
    }
    public static double inquireBalance(String phoneNumber){
        // should be some logic here
        return 10000;
    }
}
