package pass_one;

import java.util.HashMap;
import java.util.Map;

public class Type {
    private Map<String, String >TYPE;
    public Type(){
        TYPE = new HashMap<>();
        TYPE.put("ADD", "IS");
        TYPE.put("BC", "IS");
        TYPE.put("COMP", "IS");
        TYPE.put("DIV", "IS");
        TYPE.put("EQU", "AD");
        TYPE.put("DC", "DL");
        TYPE.put("DS", "DL");
        TYPE.put("BC", "DL");
        TYPE.put("END", "AD");
    }

    public String getType(String key){
        return TYPE.get(key);
    }
}
