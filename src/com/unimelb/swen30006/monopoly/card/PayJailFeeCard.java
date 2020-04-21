package com.unimelb.swen30006.monopoly.card;

import com.unimelb.swen30006.monopoly.Player;
import com.unimelb.swen30006.monopoly.square.Square;

public class PayJailFeeCard extends JailCard{
	public PayJailFeeCard(int cardValue) {
		this.cardValue = (double) cardValue;
		this.cardDescription = "No need to go to Jail but you have to pay $"+cardValue+".";
	}
	
	@Override
	public void action(Player p, Square location) {
		super.action(p, location);
		int fee = (int) Math.floor(this.cardValue);
		if(p.getCash() > fee) {
			p.reduceCash(fee);
		}else {
			System.out.println("Not enough cash. Go to jail!!");
			p.setLocation(location);
		}
		
	}

}
