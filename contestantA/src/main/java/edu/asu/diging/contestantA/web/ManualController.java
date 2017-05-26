package edu.asu.diging.contestantA.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.asu.diging.contestantA.services.Play;
import edu.asu.diging.contestantA.services.Sender;

//import edu.asu.diging.contestantA.services.Play;

@Controller
public class ManualController {
	
	
	@Autowired
	Play game;
	
	@Autowired
	Sender message;
	@RequestMapping(value = "/manual")
    public String manual(ModelMap map) {
    	map.addAttribute("game", game);
    	// toss needs to done
    	game.sendToss();
       return "manual";
    }

    
    @RequestMapping(value = "/manual", method= RequestMethod.POST)
    public String manual(@RequestParam(value = "userInput") String value, ModelMap map) {
    		map.addAttribute("userInput", value);
        	map.addAttribute("game", game);
//        	tt.toss();
        	message.send("A", value);
        	game.setPlayerOne(value);
        	game.setCurrent(value);
    	
    	
        return "manual";
    }
    
    
}
