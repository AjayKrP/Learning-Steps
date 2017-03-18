package MANAGER;
import CLIENT.ConvertCurrency;
import CLIENT.RequestBalence;
import CONSTANT.*;
import java.util.*;

public class Application {

    private int choice;
    private Message message ;
    private Management management ;
    private RequestBalence requestBalence ;
    private ConvertCurrency convertCurrency ;
    private LoanFacility loanFacility;

    public Application(){
        message = new Message();
        management = new Management();
        requestBalence = new RequestBalence();
        convertCurrency = new ConvertCurrency();
        loanFacility = new LoanFacility();
    }


    private Scanner scanner = new Scanner(System.in);


    public void welcomeMessage(){
        BankInformation bankInformation = new BankInformation();
        System.out.println(bankInformation.BankName);
    }

    public void Choice() {
        String name;
        Double balence;
        String ch= "y";

        do {
            for (int i = 0; i < message.arrayList.size(); ++i){
                System.out.println(i+1 +" " + message.arrayList.get(i));
            }
            System.out.print("Enter your choice :");
            choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    name = requestBalence.enterDetails();
                    System.out.print("Enter your initial balence: ");
                    balence = scanner.nextDouble();
                    if(balence >= 0) {
                        management.createAccount(name, balence);
                    }
                    else {
                        System.out.println("You have entere incorrect balence!!!");
                    }
                    break;

                case 2:

                  name = requestBalence.enterDetails();
                   try {

                        if(management.searchPeople(name) != null) {
                            System.out.println("Enter new balence: ");
                            balence = scanner.nextDouble();
                            if(balence >= 0){
                            management.ChangeBalence(name, management.arrayList.get(management.searchPeople(name)).getBalence() + balence);
                        }
                        else{
                            System.out.println(message.invalidAccountMessage);
                        }}
                        else {
                            System.out.println("You have entere incorrect balence!!!");
                        }
                    }
                    catch (Exception e){
                        System.out.println("Your name is not found.\n Please create acount first");
                            System.out.println(message.depositeMessage);
                   }
                    break;


                case 3:
                    try {
                        System.out.print("Enter withdrawal amount: ");
                        balence = scanner.nextDouble();
                        if(balence >= 0) {
                            requestBalence.RequestForWithdrawal(management, balence);
                            System.out.println("Withdrawal amount: " + balence);
                            System.out.println(message.widrawalMessage);
                        }
                        else {
                            System.out.println("You have entred incorrect balence!!!");
                        }
                    }catch (Exception e){
                        System.out.println("Please enter a valid amount!");
                    }

                    break;


                case 4:
                    name = requestBalence.enterDetails();
                    Double currentBalence;
                    try{
                    if(management.arrayList.get(management.searchPeople(name)) != null){
                        currentBalence = management.arrayList.get(management.searchPeople(name)).getBalence();
                        System.out.println("Your current balence is: "+currentBalence);
                    }

                    }catch (Exception e){
                        System.out.println(message.invalidAccountMessage);
                    }

                    break;


                case 5:
                    convertCurrency.changeCurrencyCountryWise(management);
                    break;

                case 6:
                    name = requestBalence.enterDetails();
                    loanFacility.takeLoan(management, name);

                    break;

                case 7:
                    management.displayAllClientName(management);
                    break;

                case 8:
                    management.displayAllClientNameWithBalence(management);
                    break;


                 default:
                     System.out.println("Choice not found!!!");
                     break;
            }
            try {
                System.out.print("Do you want to try again(y/n)? ");
                ch = scanner.next();
            }
            catch (Exception e){
                System.out.println("Enter a valid character!!!");
            }

        }while (ch != "n" || ch != "N");
    }
}
