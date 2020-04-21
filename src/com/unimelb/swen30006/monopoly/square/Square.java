package com.unimelb.swen30006.monopoly.square;

import com.unimelb.swen30006.monopoly.Player;


public abstract class Square {
	protected String name;
	protected Square nextSquare;
	protected int index;
	
	public Square(String name, int index) {
		this.name = name; 
		this.index = index;
	}

	public void setNextSquare(Square nextSquare) {
		this.nextSquare = nextSquare;
	}
	
	public Square getNextSquare() {
		return nextSquare;
	}

	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}
	
	public abstract void landedOn(Player p);
}
