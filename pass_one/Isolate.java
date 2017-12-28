package pass_one;

import java.io.*;
import java.util.*;

public class Isolate {
    private String inputFile;
    private  String outputFile;
    public ArrayList<String[]> isolatedArray;
    public Isolate(String inputFile, String outputFile){
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        isolatedArray = new ArrayList<>();
    }

    public void isolateCode(){
        FileWriter out;
        FileReader in;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            in = new FileReader(inputFile);
            out = new FileWriter(outputFile);
            br = new BufferedReader(in);
            bw = new BufferedWriter(out);
        }catch (IOException e){
            e.printStackTrace();
        }
        assert bw != null;
        try {
            while ((br.read()) != -1){
                String[] array = (br.readLine().split(","));
                isolatedArray.add(array);
            }
        } catch (NullPointerException | IOException e) {
            System.out.println("Null pointer exception");
        }
    }
}
