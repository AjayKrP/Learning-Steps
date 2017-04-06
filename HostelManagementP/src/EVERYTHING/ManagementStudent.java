package EVERYTHING;

import java.util.Scanner;

public class ManagementStudent {
    private String name;
    private Scanner scanner;
    private  String branch;
    private String mobile;
    private String address;
    SubmitStudentDetails submitStudentDetails;
    RoomDetails roomDetails;
    public ManagementStudent(){
        scanner = new Scanner(System.in);
        submitStudentDetails = new SubmitStudentDetails();
        roomDetails = new RoomDetails();
    }

    public void Deatils(){
        System.out.print("Enter name of the student: ");
        name = scanner.next();
        System.out.print("Enter branch of the student: ");
        branch = scanner.next();
        System.out.print("Enter mobile of the student: ");
        mobile = scanner.next();
    }
    private void choice(){
        System.out.println("1.Enter student details: ");
        System.out.println("2.search student");
        System.out.println("3.delete student");
        System.out.println("4.Display student");
        System.out.println("5.Modify record");
        System.out.println("6.room allotement");
        System.out.println("7.dues of spacific student");
        System.out.println("8.Leave room");
    }

    public void Main(){
        String ch = "y";
        Integer Choice;
        do{
            choice();
            System.out.print("Enter your choice : ");
            Choice = scanner.nextInt();
            switch (Choice){
                case 1:
                    Deatils();
                    System.out.print("Enter address: ");
                    address = scanner.next();
                    submitStudentDetails.AddStudentInformation(name, branch, mobile, address);
                    break;
                case 2:
                    Deatils();
                    if(submitStudentDetails.searchStudentDetails(name, branch, mobile)){
                    System.out.println("student found in our record.");
                    }else{
                        System.out.println("student not found!!!");
                     }
                    break;
                case 3:
                    Deatils();
                    submitStudentDetails.deleteStudent(name, branch, mobile);
                    break;
                case 4:
                    System.out.println("name   branch   mobile  address");
                    submitStudentDetails.displayTotalStudent();
                    break;
                    default:
                        System.exit(0);
                        break;
                case 5:
                    Deatils();
                    System.out.print("Enter address: ");
                    address = scanner.next();
                    submitStudentDetails.modifyRecord(name, branch, mobile, address);
                    break;
                case 6:
                    roomDetails.allotRoom();
                    break;
                case 7:
                    System.out.println("your current dues is: "+ roomDetails.duesOfSpecificStudent());
                    break;
                case 8:
                    roomDetails.LeaveRoom();
                    break;
            }
            System.out.print("Do you want to continue(y/n)");
            ch = scanner.next();
        }while (!ch.equals("n"));
    }
}
