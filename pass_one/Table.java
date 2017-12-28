package pass_one;


public class Table {
    private Integer Index;
    private String Mnemonic;
    private String TYPE;
    private String opCode;
    public Table(Integer Index, String... args){
        this.Index = Index;
        this.Mnemonic = args[0];
        this.TYPE = args[1];
        this.opCode = args[2];
    }

    public Integer getIndex() {
        return Index;
    }

    public String getMnemonic() {
        return Mnemonic;
    }

    public String getTYPE() {
        return TYPE;
    }

    public String getOpCode() {
        return opCode;
    }

    public void setIndex(Integer index) {
        Index = index;
    }

    public void setMnemonic(String mnemonic) {
        Mnemonic = mnemonic;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public void setOpCode(String opCode) {
        this.opCode = opCode;
    }
}
