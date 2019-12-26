package sec.project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Signup;
import sec.project.repository.SignupRepository;

@Controller
public class SignupController {

    @Autowired
    private SignupRepository signupRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String findForm() {
        signupRepository.save(new Signup("admin", "default", "default", true));
        List list = signupRepository.findAll();
        //tulostaa listan index.html:ssä
        // tarvitaan klikattavia linkkejä, jotka luovat /käyttäjänimi html:t automaattisesti 
        // vs pari ennakkoon tehtyä käyttäjää, jotka näytetään
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loadLogin() {
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submitLogin(@RequestParam String name, @RequestParam String password) {
        List<Signup> list = signupRepository.findAll();
	for (Signup temp : list) {
            String temp_name = temp.getName();
            if (temp_name.equals(name)){
                if (temp.checkPassword(password) == true){
                    return "table";
                }else{
                    return "errorLoginPassword";
                }
            }else{
                return "errorLoginName";
            }
	}
        return "index";
    }


    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String loadForm() {
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String submitForm(@RequestParam String name, @RequestParam String address, @RequestParam String password) {
        signupRepository.save(new Signup(name, address, password));
        return "index";
    }

}
