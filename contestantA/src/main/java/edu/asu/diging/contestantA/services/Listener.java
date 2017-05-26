package edu.asu.diging.contestantA.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {
	
	@Autowired
	Play game;
	
	@KafkaListener(id="test.listener.id2", topics = "B")
	public void receiveBMessage(String message) {
		game.playerTwo.add(message);
		game.setCurrent(message);
	}


}
