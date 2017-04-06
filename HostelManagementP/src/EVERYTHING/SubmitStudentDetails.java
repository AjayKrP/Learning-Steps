package EVERYTHING;


import java.util.ArrayList;
import java.util.Scanner;

public class SubmitStudentDetails {
    private static Scanner scanner;
    public static ArrayList<AddStudentDetails>addStudentDetailss = new ArrayList<>();
    public SubmitStudentDetails(){
        scanner = new Scanner(System.in);
//        addStudentDetailss = new ArrayList<>();
    }

    public void AddStudentInformation(String name, String branch, String mobile, String address){
        addStudentDetailss.add(new AddStudentDetails(name, branch, mobile, address));
    }

    public boolean searchStudentDetails(String name, String Branch, String mobile){
        for(int i = 0; i < addStudentDetailss.size(); ++i){
            if(addStudentDetailss.get(i).getName().equals(name) && addStudentDetailss.get(i).getBranch().equals(Branch) &&
                    addStudentDetailss.get(i).getMobile().equals(mobile)){
                return true;
            }
        }
        return false;
    }

    public Integer getIndex(String name, String branch, String mobile){
        for(int i = 0;i < addStudentDetailss.size(); ++i){
            if(addStudentDetailss.get(i).getName().equals(name) &&
            addStudentDetailss.get(i).getBranch().equals(branch) &&
                    addStudentDetailss.get(i).getMobile().equals(mobile) ){
                return i;
            }
        }
        return null;
    }

    public void deleteStudent(String name, String Branch, String mobile){
        if(searchStudentDetails(name, Branch, mobile)){
           int k = getIndex(name, Branch, mobile);
           addStudentDetailss.remove(k);
            System.out.println("record is deleted successfully");
        }
        else {
            System.out.println("student not found!!!");
        }
    }

    public void displayTotalStudent(){
        for(int i = 0; i < addStudentDetailss.size(); ++i){
            System.out.println(addStudentDetailss.get(i).getName() + " " +
            addStudentDetailss.get(i).getBranch()+ " "+addStudentDetailss.get(i).getMobile()+" "+
            addStudentDetailss.get(i).getAddress());
        }
    }

    public void modifyRecord(String name, String branch, String mobile, String address){
        String n_name, n_mobile, n_branch, n_address;
        if(searchStudentDetails(name, branch, mobile)){
            int k = getIndex(name, branch, mobile);
                System.out.println("Enter new name: ");
                n_name = scanner.next();
                System.out.println("Enter new branch: ");
                n_branch = scanner.next();
                System.out.println("Enter new Mobile: ");
                n_mobile = scanner.next();
                System.out.println("Enter new Address: ");
                n_address = scanner.next();
                addStudentDetailss.get(k).setName(n_name);
                addStudentDetailss.get(k).setBranch(n_branch);
                addStudentDetailss.get(k).setMobile(n_mobile);
                addStudentDetailss.get(k).setAddress(n_address);
                addStudentDetailss.set(k, addStudentDetailss.get(k));
            }
        else {
            System.out.println("Please enter correct details!!!");
        }
    }
}
