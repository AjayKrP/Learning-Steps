package MANAGER;
import CLIENT.ConvertCurrency;
import CLIENT.RequestBalence;
import CONSTANT.*;
import java.util.*;
public class Application {

    private int choice;
    private Message message;
    private CreateAccount createAccount;
    private Management management;
    private RequestBalence requestBalence;
    private CheckBalence checkBalence;
    private ConvertCurrency convertCurrency;
    private Scanner scanner = new Scanner(System.in);


    public void welcomeMessage(){
        BankInformation bankInformation = new BankInformation();
        System.out.println(bankInformation.BankName);
    }

    public void Choice() {
        String name;
        Double balence;
        int ch = 6;

        do {
            for (int i = 0; i < message.arrayList.size(); ++i){
                message.arrayList.get(i);
            }
            System.out.println("Enter your choice :");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter name : ");
                    name = scanner.nextLine();
                    balence = scanner.nextDouble();
                    createAccount.accountInfo.put(name, balence);
                    break;

                case 2:
                    System.out.println("Enter name :");
                    name = scanner.nextLine();
                    try {
                        if(management.searchPeople(createAccount.accountInfo, name)){
                            System.out.println("Enter new balence: ");
                            balence = scanner.nextDouble();
                            createAccount.accountInfo.put(name, balence);
                        }
                    }catch (Exception e){
                        System.out.println("Your name is not found.\n Please create acount first");
                    }
                    System.out.println(message.depositeMessage);
                    break;

                case 3:
                    System.out.println("Enter withdrawal amount: ");
                    balence = scanner.nextDouble();
                    requestBalence.EnterAmount(balence);
                    System.out.println(message.widrawalMessage);
                    break;


                case 4:
                    System.out.println("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.println(checkBalence.totalBalence(name));
                    break;


                case 5:
                    System.out.println("Enter amount which you want to change: ");
                    balence = scanner.nextDouble();
                    convertCurrency.enterAmount();
                    break;


                    default:
                        System.out.println("Choice not found!!!");
                        break;

            }

            System.out.println("Do you want to try again(y/n)? ");
            ch = scanner.nextInt();
        }while (ch != 6);
    }
}
