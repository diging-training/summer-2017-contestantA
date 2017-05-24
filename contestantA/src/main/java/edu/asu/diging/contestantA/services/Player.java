package edu.asu.diging.contestantA.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;


@Service
public class Player {
	public List<Integer> chosenNumbers;
	public List<Integer> seenNumbers;
	public String status;
	
	@PostConstruct
	public void initIt() throws Exception {
		chosenNumbers = new ArrayList<Integer>();
		seenNumbers = new ArrayList<Integer>();
		status = "Not Started";
	}
    
	public void chooseNumber(int n) {
		chosenNumbers.add(n);
    }
	public void getNumbers(int n){
		seenNumbers.add(n);
	}
	public int play(int current){
		// get input
		return current/2-2;
	}
}

