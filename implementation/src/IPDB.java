import java.util.*;
import java.util.ArrayList;

public class IPDB {
    private ArrayList<User> Users;
    public IPDB(){
        Users = new ArrayList<User>();
    }
    public void addAccount(User newUser){
        Users.add(newUser);
    }
    public User getAccountByUserName(String userName){
        for(int i = 0; i < Users.size(); i++){
            if(Objects.equals(Users.get(i).getUserName(), userName)){
                return Users.get(i);
            }
        }
        return null;
    }
    public User getAccountBybankAccount(String bankAccount){
        for(int i = 0; i < Users.size(); i++){
            if(Objects.equals(Users.get(i).getBankAccount(), bankAccount)){
                return Users.get(i);
            }
        }
        return null;
    }
    public User getAccountByPhoneNumber(String phoneNumber){
        for(int i = 0; i < Users.size(); i++){
            if(Objects.equals(Users.get(i).getPhoneNumber(), phoneNumber)){
                return Users.get(i);
            }
        }
        return null;
    }
    public void removeAccount(String userName){
        for(int i = 0; i < Users.size(); i++){
            if(Objects.equals(Users.get(i).getUserName(), userName)){
                Users.remove(Users.get(i));
                return;
            }
        }
    }

}
