package edu.asu.diging.contestantA.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import edu.asu.diging.contestantA.services.Play;

@Controller
public class ManualController {
	
//	@Autowired
//	Play game;

    
    @RequestMapping(value = "/manual", method= RequestMethod.POST)
    public String manual(@RequestParam("submit") String value, ModelMap map) {
//    	map.addAttribute("game", game);
    	if (value != "input")
    	{
    		System.out.println("**********" + value);
    	}
        return "manual";
    }
    
    
}
