package edu.asu.diging.contestantA.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutomaticController {

    
    @RequestMapping(value = "/automatic")
    public String automatic() {
        return "automatic";
    }
    
}
