package sec.project.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Signup extends AbstractPersistable<Long> {

    private String name;
    private String address;
    private String password;
    private boolean admin;

    public Signup() {
        super();
    }

    public Signup(String name, String address, String password) {
        this();
        this.name = name;
        this.address = address;
        this.password = password;
        admin = false;
    }
    
        public Signup(String name, String address, String password, boolean admin) {
        this();
        this.name = name;
        this.address = address;
        this.password = password;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public boolean checkPassword(String password){
        if (this.password == password){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean getAdmin(){
        return admin;
    }
    
    public void setAdmin(boolean admin){
        this.admin = admin;
    }

}
