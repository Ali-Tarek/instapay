import java.util.ArrayList;
import java.util.Objects;

public class BankProvider extends Provider {
    public BankProvider(String providerName, String providerType) {
        super(providerName, providerType);
    }
    public static double inquireBalance(String userName){
        // should be some logic here
        return 10000;
    }
}
