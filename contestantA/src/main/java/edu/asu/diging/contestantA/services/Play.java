package edu.asu.diging.contestantA.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Play {
	
	public List<Integer> playerOne;
	public List<Integer> playerTwo;
	public int currentNumber;
	
	public Play() {
		playerOne = new ArrayList<Integer>();
		playerOne.add(1);
		playerOne.add(3);
		playerOne.add(5);
		playerOne.add(7);
		playerOne.add(9);
		playerTwo = new ArrayList<Integer>();
		playerTwo.add(2);
		playerTwo.add(4);
		playerTwo.add(6);
		playerTwo.add(8);
		playerTwo.add(10);
		currentNumber = 50;
	}
	
	public List<Integer> getPlayerOne(){
		return playerOne;
	}
	
	public List<Integer> getPlayerTwo(){
		return playerTwo;
	}
	
	public int getCurrentNumber(){
		return currentNumber;
	}
    


}
