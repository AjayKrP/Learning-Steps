package MANAGER;

import java.util.ArrayList;
import java.util.HashMap;

public class CreateAccount {
    public HashMap<String, Double> accountInfo = new HashMap<>();
    private String clientName;
    private Double initialBalence;
    CreateAccount(String clientName, Double initialBalence){
        this.clientName = clientName;
        this.initialBalence = initialBalence;
        accountInfo.put(clientName, initialBalence);
    }
}
