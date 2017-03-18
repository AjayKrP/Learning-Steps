package MANAGER;
import CLIENT.Banker;
import java.util.ArrayList;


public class Management {

    public ArrayList<Banker> arrayList ;

    public Management(){
        arrayList = new ArrayList<>();
    }

    public void createAccount(String name, Double balence){
       arrayList.add(new Banker(name, balence));
    }

    public Integer searchPeople(String name) {
        for(int i = 0; i < arrayList.size(); ++i){
            if(arrayList.get(i).getName().equals(name)){
                return i;
            }
        }
        return null;
    }


    void ChangeBalence(String name,  Double balence){
        Integer k = searchPeople(name);
        if(k != null){
            arrayList.get(k).setBalence(balence);
        }
        else {
            System.out.println("Name not found!");
        }
    }


    public boolean varifyYourAccount( String name){
        if(searchPeople(name) != null){
            return true;
        }
        else {
           return false;
        }
    }


    public void displayAllClientName(Management management){
        for(int i = 0; i < management.arrayList.size(); ++i){
            System.out.println(management.arrayList.get(i).getName());
        }
    }

    public void displayAllClientNameWithBalence(Management management){
        for(int i = 0; i < management.arrayList.size(); ++i){
            System.out.println(management.arrayList.get(i).getName() + " : " + management.arrayList.get(i).getBalence());
        }
    }
}
