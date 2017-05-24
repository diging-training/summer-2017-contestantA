package edu.asu.diging.contestantA.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }
    
    @RequestMapping(value = "/manual")
    public String manual() {
        return "manual";
    }
    
    @RequestMapping(value = "/automatic")
    public String automatic() {
        return "automatic";
    }
    
    @RequestMapping(value = "/help")
    public String help() {
        return "help";
    }
}
