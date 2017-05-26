package edu.asu.diging.contestantA.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.asu.diging.contestantA.services.Play;



@Controller
public class HomeController {
	

    @RequestMapping(value = "/")
    public String home() {
//    	tt.toss();
        return "home";
    }
    
}
