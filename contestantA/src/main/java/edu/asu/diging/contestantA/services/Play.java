package edu.asu.diging.contestantA.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

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
	Queue<String> rec;
	ArrayList<String> playerOne;
	ArrayList<String> playerTwo;
	Encryption encryption;
	
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
	
	public void toss(){
		rec = new LinkedList<String>();
		send.send("question", encryption.beginToss());
		tossValue = encryption.getTossValue();
		//change logic here
		while(rec.size()==0){
			System.out.println("Waiting ...."+rec.size());
		}
		System.out.println("Received the very first message");
		String message = rec.poll();
		int tossChoice = Integer.parseInt(message);
		send.send("question", "Number Chosen for Toss: "+ tossValue);
		// odd is 0
		// even is 1
		if((tossChoice == 1 && Integer.parseInt(tossValue) % 2 == 0) || (tossChoice == 0 && Integer.parseInt(tossValue) % 2 == 1)){
			// B Wins
			System.out.println("B Won...");
			send.send("question", "You won the toss!!! Start the game");
			while(rec.size()==0){
				System.out.println("Waiting ...."+rec.size());
			}
			message = rec.poll();
			started = true;
			current = Integer.parseInt(message);
			int chosen = logicAndSend();
			
		}
		else{
			// A Wins
			current = logicAndSend();
			started = true;
		}
		//change logic here
		while(current>0)
		{
			while(rec.size()==0)
			{
				System.out.println("Waiting ...."+rec.size());
			}
			message = rec.poll();
			current -= Integer.parseInt(message);
			if(current == 0){
				break;
			}
			int chosen = logicAndSend();
		}
		
	}
	public int logic()
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
	public int logicAndSend()
	{
		int num = logic();
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
	    logger.info("Received here topic: " + message);
		System.out.println("Received topic: " + message);
		rec.offer(message);
	}
	
	@KafkaListener(id="test.listener.id2", topics = "B")
	public void receiveBMessage(String message) {
	    logger.info("Received here topic: " + message);
		System.out.println("Received topic: " + message);
		playerTwo.add(message);
		setCurrent(message);
	}
	
}
