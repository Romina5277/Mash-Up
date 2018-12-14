package viewControlling;

import dbAufruf.DbConnection;
import objectsDB.Account;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean
@SessionScoped
public class LoginView implements Serializable {

    private ArrayList<Account> accs;
    private Account acc = new Account();
    private String username;
    private String password;
    private String message;
    private Boolean fail = true;

    public LoginView() {
        DbConnection conn = new DbConnection();
        conn.connection("account");

        accs = conn.getAccs();

    }

    public String buttonAction(){

        fail = true;
        message = "";

        for (Account acc : accs) {
            if(acc.getUsername().equals(username)){
                if (acc.getPassword().equals(password)){
                    fail = false;
                }
            }
        }

        if (fail){
            message = "wrong username or password";
            return "Login.xhtml";
        } else {
            message = "";
            return "Home.xhtml";
        }
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public ArrayList<Account> getAccs() {
        return accs;
    }

    public void setAccs(ArrayList<Account> accs) {
        this.accs = accs;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getFail() {
        return fail;
    }

    public void setFail(Boolean fail) {
        this.fail = fail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
