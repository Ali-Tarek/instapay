import java.util.ArrayList;
import java.util.Objects;

public class Provider {
    private String providerName;
    private String providerType;
    private Pair<String, Double> accountBalance;
    public Provider(String providerName, String providerType, Pair<String, Double> accountBalance){
        this.providerName = providerName;
        this.providerType = providerType;
        this.accountBalance = accountBalance;
    }
    public Double getAccountBalance(){
        return this.accountBalance.second;
    }
    public void setAccountBalance(Double amount){
        this.accountBalance.second = amount;
    }
    public String getProviderName() {
        return providerName;
    }
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    public String getproviderType() {
        return providerType;
    }
    public void setproviderType(String providerType) {
        this.providerType = providerType;
    }

    public boolean verifyPhoneNumber(String phoneNumber){
        // should be some logic here
        return true;
    }

    public void addBalance(Double amount){
        this.accountBalance.second += amount;
    }

}
