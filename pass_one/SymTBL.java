package pass_one;


import java.util.ArrayList;


public class SymTBL {
    private ArrayList<Table> tables;
    private OpCode opCode;
    ArrayList arrayList;
    private Type type;
    private Isolate isolate;
    public SymTBL(String inputFile, String outputFile){
        type = new Type();
        opCode = new OpCode();
        isolate = new Isolate(inputFile, outputFile);
        arrayList = isolate.isolatedArray;
        tables = new ArrayList<>();
    }


    public void PrintInputCode(){
        isolate.isolateCode();
        try{
            arrayList = isolate.isolatedArray;
        } catch(NullPointerException e){
            e.printStackTrace();
        }
        for (Object anArrayList : arrayList) {
            String[] arr = (String[]) anArrayList;
            for (String anArr : arr) {
                System.out.printf("%s\t", anArr);
            }
            System.out.println();
        }
    }

    public void makeSymbolTable(){
        int startIndex = FindStartPosition();
        int count = 0;
        String Mnemonic = "";
        String TYPE = "";
        String OPCODE = "";
        for (Object anArrayList : arrayList) {
            count++;
            String[] arr = (String[]) anArrayList;
            for (int i = 0; i < arr.length; ++i) {
                try {
                    Mnemonic = arr[0];
                    TYPE = type.getType(arr[1]);
                    OPCODE = arr[2];
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(e.toString());
                }
            }
            try {
                tables.add(new Table(count, Mnemonic, TYPE, OPCODE));
            } catch (NullPointerException e){
                System.out.println("Null pointer exception from makeSymbolTable(): "+ e.toString());
            }
            System.out.println();
        }
    }

    public void printSymbolTable(){
        for (Table element : tables) {
            System.out.println(element.getIndex() + " " + element.getMnemonic() + " " + element.getTYPE() + " " + element.getOpCode());
        }
    }

    public int FindStartPosition(){
        int count = 0;
        for (Object anArrayList : arrayList) {
            count ++;
            String[] arr = (String[]) anArrayList;
            for (String anArr : arr) {
                if (anArr.equals("start") || anArr.equals("start".toUpperCase())){
                    return count;
                }
            }
            System.out.println();
        }
        return 0;
    }
}
