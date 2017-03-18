package MANAGER;
import CONSTANT.Message;

import java.util.Scanner;

public class LoanFacility {
    Message message;
    public final double interestRate = 10.0;
    private  Scanner scanner = new Scanner(System.in);

    public LoanFacility(){
         message = new Message();
    }

    //If your current balence is negative that means you already taken loan

    public void takeLoan(Management management, String name){
        if(management.varifyYourAccount(name)){
            Double amount;
            System.out.print("Enter loan amount: ");
            amount = scanner.nextDouble();
            System.out.println("Your interest rate is "+interestRate);
            management.arrayList.get(management.searchPeople(name)).setBalence(management.arrayList.get(management.searchPeople(name)).getBalence() - amount);
        }

        else {
            System.out.println(message.invalidAccountMessage);
        }
    }
}
