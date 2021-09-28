package parameterized_tests.models;


public class ContactData {

    private String fullName;
    private String phone;
    private String mail;
    private String github;

    public ContactData(String fullName, String phone, String mail) {
        this.fullName = fullName;
        this.phone = phone;
        this.mail = mail;
    }

    public ContactData() {
    }

    public String getFullName() {
        return fullName;
    }

    public ContactData setFullName(String fullName) {
        this.fullName = fullName;
        return null;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
}
