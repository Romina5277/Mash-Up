package viewControlling;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("viewLogin")
@RequestScoped
public class ViewLogin {
    public String getString(){
        return "blub";
    }
}
