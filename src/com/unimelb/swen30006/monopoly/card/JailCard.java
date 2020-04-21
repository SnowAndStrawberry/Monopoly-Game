package com.unimelb.swen30006.monopoly.card;
import com.unimelb.swen30006.monopoly.Player;
import com.unimelb.swen30006.monopoly.square.Square;

public abstract class JailCard {
	double cardValue;
	String cardDescription;
	public void action(Player p, Square location) {
		System.out.println(cardDescription);
	}
}
