package edu.asu.diging.contestantA.services;

import org.springframework.stereotype.Service;

@Service
public class Mediator {
	public int current;
	public Player p;
	public void got(int n){
		p.getNumbers(n);
		current -= n;
	}
	public int play(){
		int chosen = p.play(current);
		if(gameOver(chosen)){
			System.out.println("Contestant A wins the game!!");
			return -1;
		}
		else{
			p.chooseNumber(chosen);
			current += chosen;
			return chosen;
		}
	}
	public boolean gameOver(int chosen){
		return Math.round(current-chosen)==0 ;
	}
}
