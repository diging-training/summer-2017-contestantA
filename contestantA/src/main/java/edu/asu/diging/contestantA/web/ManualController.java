package edu.asu.diging.contestantA.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManualController {

    
    @RequestMapping(value = "/manual")
    public String manual() {
        return "manual";
    }
    
}
