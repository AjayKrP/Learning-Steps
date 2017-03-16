package CLIENT;
import  MANAGER.*;
import java.util.*;
public class RequestBalence {
    private double requestedBalence;
    private Management management;
    //private Double amount;
    private CheckBalence checkBalence;
    private String name;
    private CreateAccount createAccount;
    private Scanner scanner = new Scanner(System.in);


    public String enterDetails(){
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        return name;
    }


    public void EnterAmount(Double amount){
        try{
            enterDetails();
            if(management.searchPeople(createAccount.accountInfo, name)){
                //System.out.println("Enter amount which you want to change :");
                //amount = scanner.nextDouble();
                if (checkBalence.totalBalence(name) > 0){
                    if(amount > checkBalence.totalBalence(name)){
                        System.out.println("No sufficient balence!!!");
                    }
                    else{
                        createAccount.accountInfo.put(name, checkBalence.totalBalence(name) - amount);
                    }
                }
            }
        } catch (Exception e){
            System.out.println("Your details is not correct!!!\n");
        }
    }
}
