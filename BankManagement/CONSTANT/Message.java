package CONSTANT;
import java.util.ArrayList;
import java.util.HashMap;

public class Message {
    public ArrayList<String> arrayList = new ArrayList<>();

    Message(){
        arrayList.add("Create Account");
        arrayList.add("Deposite");
        arrayList.add("Withdrawal");
        arrayList.add("Balence Check");
        arrayList.add("Change currency");
    }
    public String widrawalMessage = "You have successfully withrawal the money";
    public String depositeMessage = "You have successfully deposited money";
}
