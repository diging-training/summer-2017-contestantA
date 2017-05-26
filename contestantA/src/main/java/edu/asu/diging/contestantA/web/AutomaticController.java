package edu.asu.diging.contestantA.web;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.asu.diging.contestantA.services.Play;
import edu.asu.diging.contestantA.services.Sender;

@Controller
public class AutomaticController {

	@Autowired
	Play game;

	@Autowired
	Sender message;


	@RequestMapping(value = "/automatic")
	public String automatic() {
		return "automatic";
	}

	@RequestMapping(value = "/automatic", method= RequestMethod.POST)
	public String automatic(ModelMap map) {
		map.addAttribute("game", game);
		//        	tt.toss();
		Random rand = new Random();
		String numberPlay;
		if (game.getCurrentNumber() == 0)
		{
			return "home";
		}
		else if (game.getCurrentNumber() <= 1)
		{
			numberPlay = Integer.toString(1);
		}
		else
		{
			int temp = rand.nextInt(game.getCurrentNumber()/2) + 1;
			numberPlay = Integer.toString(temp);
		}

		message.send("A", numberPlay);
		game.setPlayerOne(numberPlay);
		game.setCurrent(numberPlay);


		return "automatic";
	}

}
