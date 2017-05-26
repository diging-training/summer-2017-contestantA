package edu.asu.diging.contestantA.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {
	
	@Autowired
	Play game;
	
	@KafkaListener(id = "test.listener.id", topics = "answer")
	public void receiveMessage(String message) {
		game.gamePlay(message);
		game.playerTwo.add(message);
		game.setCurrent(message);
	}

	@KafkaListener(id = "test.listener.toss", topics = "toss")
	public void tossListener(String message) {
		game.receiveToss(message);
	}

	@KafkaListener(id = "test.listener.tossWinner", topics = "tossWinner")
	public void tossWinListener(String message) {
		game.BStarts(message);
	}


}
