package EVERYTHING;
import java.util.HashMap;
import java.util.Scanner;

public class RoomDetails extends SubmitStudentDetails{
    private static Integer singleRoom = 100;
    private static Integer doubleRoom = 150;
    private static Integer trippleRoom = 200;
    private  final Double costSingle = 83000.0;
    private  final Double costDouble = 78000.0;
    private  final Double costTripple = 72000.0;
    private Integer roomNumber;
    private Scanner scanner;
    private  static HashMap<AddStudentDetails, Double>hashMap;
    public RoomDetails(){
        scanner = new Scanner(System.in);
        hashMap = new HashMap<>();
    }

    private static String name;
    private static String branch;
    private static String mobile;

    private void enterDetails(){
        System.out.print("Enter name: ");
        name = scanner.next();
        System.out.print("Enter branch: ");
        branch = scanner.next();
        System.out.print("Enter mobile: ");
        mobile = scanner.next();
    }

    private void singleRoomAllotment(){
        enterDetails();
        if(searchStudentDetails(name, branch, mobile)) {
            System.out.print("Enter room number: ");
            roomNumber = scanner.nextInt();
            if (roomNumber > 0 || roomNumber <= 100) {
                Double currentBalance;
                System.out.print("Enter your current balance which you are going to pay: ");
                currentBalance = scanner.nextDouble();
                if(currentBalance > costSingle/2) {
                    if (currentBalance.equals(costSingle)) {
                        --singleRoom;
                        System.out.println("your room is issued successfully.");
                    } else {
                        Integer i = getIndex(name, branch, mobile);
                        hashMap.put(SubmitStudentDetails.addStudentDetailss.get(i), costSingle - currentBalance);
                    }
                }else {
                    System.out.println("you have to pay at least half at one time.");
                }

            } else {
                System.out.println("You have entered incorrect room number!!!");
                System.out.println("Please enter correct room number!!!");
            }
        }else {
            System.out.println("Student details not found!!");
        }
    }

    private void doubleRoomAllotment(){
        System.out.print("Enter room number: ");
        roomNumber = scanner.nextInt();
        enterDetails();
        if(searchStudentDetails(name, branch, mobile)) {
            System.out.print("Enter room number: ");
            roomNumber = scanner.nextInt();
            if (roomNumber > 100 || roomNumber <= 250) {
                Double currentBalance;
                System.out.print("Enter your current balance which you are going to pay: ");
                currentBalance = scanner.nextDouble();
                if(currentBalance > costDouble/2) {
                    if (currentBalance.equals(costDouble)) {
                        --doubleRoom;
                        System.out.println("your room is issued successfully.");
                    } else {
                        Integer i = getIndex(name, branch, mobile);
                        hashMap.put(SubmitStudentDetails.addStudentDetailss.get(i), costDouble - currentBalance);
                    }
                }else{
                    System.out.println("you have to pay at least half at one time.");
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

    private void trippleRoomAllotment(){
        System.out.print("Enter room number: ");
        roomNumber = scanner.nextInt();
        enterDetails();
        if(searchStudentDetails(name, branch, mobile)) {
            System.out.print("Enter room number: ");
            roomNumber = scanner.nextInt();
            if (roomNumber > 250 || roomNumber <= 450) {
                Double currentBalance;
                System.out.print("Enter your current balance which you are going to pay: ");
                currentBalance = scanner.nextDouble();
                if(currentBalance > costTripple/2)
                if(currentBalance.equals(costTripple)){
                    --trippleRoom;
                    System.out.println("your room is issued successfully.");
                }else {
                    Integer i = getIndex(name, branch, mobile);
                    hashMap.put(SubmitStudentDetails.addStudentDetailss.get(i), costTripple-currentBalance);
                }
                else {
                    System.out.println("you have to pay at least half at one time.");
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

    public void LeaveRoom(){
        enterDetails();
        if(searchStudentDetails(name, branch, mobile)){
            System.out.println("Enter your room number: ");
            roomNumber = scanner.nextInt();
            int k = getIndex(name, branch, mobile);
            if(hashMap.get(addStudentDetailss.get(k)) == 0.0){
                if(roomNumber > 0 && roomNumber <= 100){
                    hashMap.remove(addStudentDetailss.get(k));
                    singleRoom++;
                }
                else if (roomNumber > 100 && roomNumber <= 250){
                    hashMap.remove(addStudentDetailss.get(k));
                    doubleRoom++;
                }
                else if (roomNumber > 250 && roomNumber <= 450){
                    hashMap.remove(addStudentDetailss.get(k));
                    trippleRoom++;
                }
                else {
                    System.out.println("Please enter correct room number!!!");
                }
            }
            else {
                System.out.println("You can't leave without paying!!!");
            }
        }
    }
    public void allotRoom(){
        Integer room;
        System.out.print("Enter room details(single/double/triple): ");
        room = scanner.nextInt();
        switch (room){
            case 1:
                singleRoomAllotment();
                break;
            case 2:
                doubleRoomAllotment();
                break;
            case 3:
                trippleRoomAllotment();
                break;
                default:
                    System.out.println("Please enter correct choice!!!");
                    break;
        }
    }

    public Double duesOfSpecificStudent(){
        enterDetails();
        if(searchStudentDetails(name, branch, mobile)){
            int k = getIndex(name, branch, mobile);
              return hashMap.get(addStudentDetailss.get(k));
        }
        return null;
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
