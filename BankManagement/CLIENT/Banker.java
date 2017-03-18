package CLIENT;

public class Banker {
    private String name;
    private Double balence;

    public Banker(String name, Double balence){
        this.name = name;
        this.balence = balence;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalence(Double balence) {
        this.balence = balence;
    }

    public Double getBalence() {
        return balence;
    }

}
