package com.unimelb.swen30006.monopoly.square;



import com.unimelb.swen30006.monopoly.Player;
import com.unimelb.swen30006.monopoly.card.LuckCardsFacade;

import java.util.Random;

public class GoToJailSquare extends Square {
private Square jail;
	
	public GoToJailSquare(String name, int index) {
		super(name, index);
	}
	
	public void setJail(Square jail){
		this.jail = jail;
	}

	@Override
	public void landedOn(Player p) {
		p.setLocation(jail);
		//Random 
		// 0 - Jail Excemption card
		// 1 , 2- Go To Jail Card
		// 3 , 4 - Pay Jail Fee Card
		Random ran = new Random();
		//print out 0 - 4 randomly
		LuckCardsFacade card = new LuckCardsFacade(ran.nextInt(5));
		
		System.out.println(card.getOutcome());
	
	}

}
