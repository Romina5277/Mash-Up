package objectsDB;

public class Account {
    private int user_id;
    private String username;
    private String e_mail;
    private String password;
    private String wohnort;
    private String schulort;

    public Account() {

    }

    public Account(int user_id, String username, String e_mail, String password, String wohnort, String schulort) {
        this.user_id = user_id;
        this.username = username;
        this.e_mail = e_mail;
        this.password = password;
        this.wohnort = wohnort;
        this.schulort = schulort;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public String getSchulort() {
        return schulort;
    }

    public void setSchulort(String schulort) {
        this.schulort = schulort;
    }
}
