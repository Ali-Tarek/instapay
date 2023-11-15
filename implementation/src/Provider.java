import java.util.ArrayList;
import java.util.Objects;

public class Provider {
    private String providerName;
    private String providerType;
    private ArrayList<Pair<String, Double>> accountsBalance;
    public Provider(String providerName, String providerType){
        this.providerName = providerName;
        this.providerType = providerType;
        accountsBalance = new ArrayList<>();
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

    public void addBalance(String data, double amount){
        for(int i = 0; i < accountsBalance.size(); i++){
            if(Objects.equals(accountsBalance.get(i).first, data)){
                accountsBalance.get(i).second += amount;
                return;
            }
        }
    }

}
