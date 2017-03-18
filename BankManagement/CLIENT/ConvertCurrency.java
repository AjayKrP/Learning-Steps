package CLIENT;
import MANAGER.*;
import java.util.*;


public class ConvertCurrency {
    private Double amount;
    private String countryCode;
    private Database database;
    private Double changedAmount;
    private RequestBalence requestBalence;
    private String name;

    public ConvertCurrency(){
        database = new Database();
        requestBalence = new RequestBalence();
    }

    private Scanner scanner = new Scanner(System.in);

    public Double changeCurrencyCountryWise(Management management){
        name = requestBalence.enterDetails();

        System.out.println("Enter country code: ");
        countryCode = scanner.next();
        try {
            if(database.database.containsKey(countryCode)){
                System.out.println("Enter amont which you want to convert: ");
                amount = scanner.nextDouble();
                changedAmount = amount*database.database.get(countryCode);
                System.out.println("Your changed amount is : "+ changedAmount);
                System.out.print("Do you want to withdrawal it (y/n) ?");
                String choice;
                choice = scanner.next();
                if(choice != "n"){
                    if(changedAmount <= management.arrayList.get(management.searchPeople(name)).getBalence()) {
                        management.arrayList.get(management.searchPeople(name)).setBalence(management.arrayList.get(management.searchPeople(name)).getBalence() - changedAmount);
                    }
                    else {
                        System.out.println("Your changed amount is greater than your current balence.\nYou may try for loan facilility.");
                    }
                }else {
                    System.out.println("Thank you");
                }
            }

        }catch (Exception e){
            System.out.println("Country code not found in our database.");
        }
        return changedAmount;
    }
}
