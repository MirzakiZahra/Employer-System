import java.util.Date;

public class Employer {
    private String firstname;
    private String lastname;
    private int personnelnumber;
    private String birthday;
    private Department department;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getPersonnelnumber() {
        return personnelnumber;
    }

    public void setPersonnelnumber(int personnelnumber) {
        this.personnelnumber = personnelnumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}