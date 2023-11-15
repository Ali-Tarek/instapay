import java.util.ArrayList;
import java.util.Objects;
import java.util.*;

public class BankProvider extends Provider {
    public BankProvider(String providerName, String providerType, Pair<String, Double> accountBalance) {
        super(providerName, providerType,  accountBalance);
    }
    public static double inquireBalance(String userName){
        // should be some logic here
        return 10000;
    }
}
