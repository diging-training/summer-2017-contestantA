package edu.asu.diging.contestantA.services;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Play {
	@Autowired
	private Sender send;
	final static Logger logger = Logger.getLogger(Play.class);
	boolean started = false;
	private String tossValue;
	boolean won = false;
	int current = -1;
	ArrayList<String> playerOne;
	ArrayList<String> playerTwo;
	Toss toss;
	
	Play(){
		playerOne = new ArrayList<String>();
		playerTwo = new ArrayList<String>();
		Random rand = new Random();
		current = rand.nextInt(100);
	}
	
	public int getCurrentNumber(){
		return current;
	}
	public int getHalfCurrentNumber(){
		return current/2;
	}
	public ArrayList<String> getListOfANumbers(){
		return playerOne;
		
	}
	public ArrayList<String> getListOfBNumbers(){
		return playerTwo;
		
	}
	
	public void setPlayerOne(String str){
		playerOne.add(str);
	}
	
	public void setPlayerTwo(String str){
		playerTwo.add(str);
	}
	
	public void setCurrent(String str){
		current -= Integer.parseInt(str);
	}
	
	public void sendToss()
	{
		send.send("question", toss.beginToss());
		tossValue = toss.getTossValue();
	}
	
	public void BStarts(String message)
	{
		started = true;
		current = Integer.parseInt(message);
		updateCurrentNumber();
	}
	
	private void AStarts()
	{
		current = updateCurrentNumber();
		started = true;
	}
	
	public void receiveToss(String message)
	{
		int tossChoice = Integer.parseInt(message);
		// odd is 0 & even is 1
		if((tossChoice == 1 && Integer.parseInt(tossValue) % 2 == 0) || (tossChoice == 0 && Integer.parseInt(tossValue) % 2 == 1)){
			// B Wins
		}
		else
		{
			// A Wins
			AStarts();
		}
	}
	
	public void gamePlay(String message)
	{
		current = current - Integer.parseInt(message);
		if(current == 0)
		{
			//update UI here
		}
		else
		{
			updateCurrentNumber();
		}
	}
	
	private int calculateChoice()
	{
		int choice;
		if(!started)
		{
			Random rand = new Random();
			choice = (int)rand.nextInt(100) + 50; 
			return choice;
		}
		else
		{
			choice = Math.max(1,(int)Math.round(current/2));
			return choice;

		}
	}
	private int updateCurrentNumber()
	{
		int num = calculateChoice();
		current = current - num;
		if(current == 0){
			//create call to UI to update to "I won"
		}
		else
		{
			send.send("question",Integer.toString(num));
		}
		return num;
	}
	
	@KafkaListener(id="test.listener.id", topics = "answer")
	public void receiveMessage(String message) {
	    	gamePlay(message);
	    	playerTwo.add(message);
	    	setCurrent(message);
	}

	@KafkaListener(id="test.listener.toss", topics = "toss")
	public void tossListener(String message)
	{
		receiveToss(message);
	}
	
	@KafkaListener(id="test.listener.tossWinner", topics = "tossWinner")
	public void tossWinListener(String message)
	{
		BStarts(message);
	}
}
