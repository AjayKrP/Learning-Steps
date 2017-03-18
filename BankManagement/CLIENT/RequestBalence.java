package CLIENT;
import  MANAGER.*;
import java.util.*;
public class RequestBalence {
    private String name;
    private Scanner scanner = new Scanner(System.in);



    public String enterDetails(){
        System.out.print("Enter your Account number: ");
        name = scanner.next();
        return name;
    }

    public void RequestForWithdrawal(Management management, Double amount){
        try{
            enterDetails();
            if(management.searchPeople(name) != null){

                if (management.arrayList.get(management.searchPeople(name)).getBalence() > 0){

                    if(amount > management.arrayList.get(management.searchPeople(name)).getBalence()){
                        System.out.println("No sufficient balence!!!");
                    }

                    else{
                        management.arrayList.get(management.searchPeople(name)).setBalence(management.arrayList.get(management.searchPeople(name)).getBalence() - amount);
                    }
                }
            }

        } catch (Exception e){
            System.out.println("Your details is not correct!!!\n");
        }
    }
}
