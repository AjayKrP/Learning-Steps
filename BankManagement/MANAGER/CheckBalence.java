package MANAGER;


public class CheckBalence {
    private CreateAccount createAccount;
    private Management management;
    public Double totalBalence(String name){
        if(management.searchPeople(createAccount.accountInfo,name)){
            return createAccount.accountInfo.get(name);
        }
        return null;
    }
}
