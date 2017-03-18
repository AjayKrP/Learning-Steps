package CONSTANT;
import java.util.ArrayList;


public class Message {
    public ArrayList<String> arrayList = new ArrayList<>();

    public Message(){
        arrayList.add("Create Account");
        arrayList.add("Deposite");
        arrayList.add("Withdrawal");
        arrayList.add("Balence Check");
        arrayList.add("Change currency");
        arrayList.add("Take Loan");
        arrayList.add("Display All client name");
        arrayList.add("Display All Client name with balence");
    }
    public String widrawalMessage = "You have successfully withrawal the money";
    public String depositeMessage = "You have successfully deposited money";
    public String invalidAccountMessage = "Your details not found!\nmake sure you entered a valid name.\n or otherwise create your account first.";
}
