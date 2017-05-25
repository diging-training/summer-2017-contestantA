package edu.asu.diging.contestantA.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.asu.diging.contestantA.services.Play;

@Controller
public class ManualController {
	
	@Autowired
	Play game;

    
    @RequestMapping(value = "/manual", params= {"submit"})
    public String manual(@RequestParam("submit") String value, ModelMap map) {
    	map.addAttribute("game", game);
        return "manual";
    }
    
    
}
