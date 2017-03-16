package MANAGER;
import java.util.HashMap;
import java.util.Iterator;


public class Management {
    private HashMap<String, Double> hashMap;
    public boolean searchPeople(HashMap<String, Double>hashMap, String name){
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            HashMap.Entry pair = (HashMap.Entry)iterator.next();
            if(pair.getValue().equals(name)){
                return true;
            }
        }
        return false;
    }
}
