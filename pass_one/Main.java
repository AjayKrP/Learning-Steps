package pass_one;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileHandlers fileHandlers = new FileHandlers();
        String inputFile = fileHandlers.INPUT_FILE;
        String outputFile =fileHandlers.OUTPUT_FILE;
        SymTBL symTBL = new SymTBL(inputFile, outputFile);
        symTBL.PrintInputCode();
        symTBL.makeSymbolTable();
        symTBL.printSymbolTable();
    }
}
