package EVERYTHING;


import java.util.HashMap;
import java.util.Scanner;

public class RoomDetails {
    private static Integer singleRoom = 100;
    private static Integer doubleRoom = 150;
    private static Integer trippleRoom = 200;
    private Double costSingle = 83000.0;
    private Double costDouble = 78000.0;
    private Double costTripple = 72000.0;
    private Integer roomNumber;
    private Scanner scanner;
    private SubmitStudentDetails submitStudentDetails;
    public HashMap<AddStudentDetails, Double>hashMap;
    public RoomDetails(){
        scanner = new Scanner(System.in);
         submitStudentDetails = new SubmitStudentDetails();
        hashMap = new HashMap<>();
    }

    Integer getIndex(String name, String branch, String mobile){
        for(int i = 0; i < submitStudentDetails.addStudentDetailss.size(); ++i){
            if(submitStudentDetails.addStudentDetailss.get(i).getName().equals(name) &&
                    submitStudentDetails.addStudentDetailss.get(i).getMobile().equals(mobile) &&
                    submitStudentDetails.addStudentDetailss.get(i).getBranch().equals(branch) ){
                return i;
            }
        }
        return null;
    }
    String name;
    String branch;
    String mobile;

    public void enterDetails(){
        System.out.print("Enter room number: ");
        roomNumber = scanner.nextInt();
        System.out.print("Enter name: ");
        name = scanner.next();
        System.out.print("Enter branch: ");
        branch = scanner.next();
        System.out.print("Enter mobile: ");
        mobile = scanner.next();
    }

    public void singleRoomAllotment(){
        enterDetails();
        if(submitStudentDetails.searchStudentDetails(name, branch, mobile)) {
            if (roomNumber > 0 || roomNumber <= 100) {
                Double currentBalance;
                System.out.print("Enter your current balance which you are going to pay: ");
                currentBalance = scanner.nextDouble();
                if(currentBalance.equals(costSingle)){
                    --singleRoom;
                    System.out.println("your room is issued successfully.");
                }else {
                    Integer i = getIndex(name, branch, mobile);
                    hashMap.put(submitStudentDetails.addStudentDetailss.get(i), costSingle-currentBalance);
                }

            } else {
                System.out.println("You have entered incorrect room number!!!");
                System.out.println("Please enter correct room number!!!");
            }
        }else {
            System.out.println("Student details not found!!");
        }
    }

    public void doubleRoomAllotment(){
        System.out.print("Enter room number: ");
        roomNumber = scanner.nextInt();
        enterDetails();
        if(submitStudentDetails.searchStudentDetails(name, branch, mobile)) {
            if (roomNumber > 100 || roomNumber <= 250) {
                Double currentBalance;
                System.out.print("Enter your current balance which you are going to pay: ");
                currentBalance = scanner.nextDouble();
                if(currentBalance.equals(costDouble)){
                    --doubleRoom;
                    System.out.println("your room is issued successfully.");
                }else {
                    Integer i = getIndex(name, branch, mobile);
                    hashMap.put(submitStudentDetails.addStudentDetailss.get(i), costDouble-currentBalance);
                }
            } else {
                System.out.println("You have entered incorrect room number!!!");
                System.out.println("Please enter correct room number!!!");
            }
        }
        else {
            System.out.println("Student details not found!!!");
        }
    }

    public void trippleRoomAllotment(){
        System.out.print("Enter room number: ");
        roomNumber = scanner.nextInt();
        enterDetails();
        if(submitStudentDetails.searchStudentDetails(name, branch, mobile)) {
            if (roomNumber > 250 || roomNumber <= 450) {
                Double currentBalance;
                System.out.print("Enter your current balance which you are going to pay: ");
                currentBalance = scanner.nextDouble();
                if(currentBalance.equals(costTripple)){
                    --trippleRoom;
                    System.out.println("your room is issued successfully.");
                }else {
                    Integer i = getIndex(name, branch, mobile);
                    hashMap.put(submitStudentDetails.addStudentDetailss.get(i), costTripple-currentBalance);
                }
            } else {
                System.out.println("You have entered incorrect room number!!!");
                System.out.println("Please enter correct room number!!!");
            }
        }
        else {
            System.out.println("Student details not found!!");
        }
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public static Integer getDoubleRoom() {
        return doubleRoom;
    }

    public static Integer getSingleRoom() {
        return singleRoom;
    }

    public static Integer getTrippleRoom() {
        return trippleRoom;
    }
}
