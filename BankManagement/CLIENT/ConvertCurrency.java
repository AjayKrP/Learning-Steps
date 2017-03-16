package CLIENT;
import MANAGER.*;
import CONSTANT.*;
import java.util.*;


public class ConvertCurrency {
    private Double amount;
    private Message message;
    private CheckBalence checkBalence;
    private String countryCode;
    private RequestBalence requestBalence;
    private Database database;
    private String name;
    private Double changedAmount;
    private Scanner scanner = new Scanner(System.in);
    public void enterAmount(){
        System.out.println("Enter country code: ");
        countryCode = scanner.next();
        try {
            if(database.database.containsKey(countryCode)){
                System.out.println("Enter amont which you want to convert: ");
                amount = scanner.nextDouble();
                name = requestBalence.enterDetails();
                changedAmount = amount*database.database.get(name);
                requestBalence.EnterAmount(changedAmount);
                System.out.println(message.widrawalMessage);
            }
        }catch (Exception e){
            System.out.println("Country code not found in our database.");
        }
    }
}
