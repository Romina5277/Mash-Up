package viewControlling;

import objectsDB.Account;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginView implements Serializable {

    private Account acc = new Account();
    private String blub = "blub";

    public LoginView() {
        acc.setUser_id(1);
        acc.setUsername("Romina");
        acc.setE_mail("keine");
        acc.setPassword("Romina");
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public String getBlub() {
        return blub;
    }

    public void setBlub(String blub) {
        this.blub = blub;
    }
}
