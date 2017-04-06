package EVERYTHING;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Problems extends RoomDetails{
    HashMap<Integer, String> studentsProblems;

    BufferedReader reader;
    private static Scanner sc;
    private static String problems;
    private static Integer roomNumber;
    public Problems(){
        studentsProblems = new HashMap<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
        sc = new Scanner(System.in);
    }

    public void EnterProblemsRoomNumberWise() throws IOException{
        enterDetails();

        if(searchStudentDetails(name, branch, mobile)){
            System.out.print("Enter your room number: ");
            roomNumber = sc.nextInt();
            System.out.println("Enter your problems ? ");
            problems = reader.readLine();
            studentsProblems.put(roomNumber, problems);
        }
    }
}
