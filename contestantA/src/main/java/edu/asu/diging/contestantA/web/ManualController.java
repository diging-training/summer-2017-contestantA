package edu.asu.diging.contestantA.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.asu.diging.contestantA.services.Player;

@Controller
public class ManualController {
	
//	@Autowired
//	Play game;

    
    @RequestMapping(value = "/manual")
    public String manual(ModelMap map) {
//    	map.addAttribute("game", game);
        return "manual";
    }
    
}
