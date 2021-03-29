package implementation;

public class User {
    public String lastname;
    public String firstname;

    public User(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public User() {

    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
