package EVERYTHING;


public class AddStudentDetails {
    private String name;
    private String branch;
    private String mobile;
    private String Address;


    public AddStudentDetails(String name, String branch, String mobile, String Address) {
        this.name = name;
        this.branch = branch;
        this.mobile = mobile;
        this.Address = Address;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return Address;
    }

    public String getBranch() {
        return branch;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setName(String name) {
        this.name = name;
    }
}

