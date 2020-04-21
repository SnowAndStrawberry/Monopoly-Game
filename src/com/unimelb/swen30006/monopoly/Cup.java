package com.unimelb.swen30006.monopoly;

import java.util.ArrayList;
import java.util.List;


public class Cup {
	
	private static List<Die> dice;
	private static int total;
	
	public static void initialize(int numOfDice) {
		dice = new ArrayList<Die>(numOfDice);
		for (int i = 0; i < numOfDice; i++ ){
			dice.add(new Die());
		}
	}
	
	/**
	 * roll all the dice
	 */
	public static void roll(){
		total = 0;
		for (Die die:dice){
			die.roll();
			total += die.getFaceValue();
		}
	}
	
	public static int getTotal(){
		return total;
	}

}
