package com.unimelb.swen30006.monopoly.card;

import com.unimelb.swen30006.monopoly.Player;
import com.unimelb.swen30006.monopoly.square.Square;

public class GoToJailCard extends JailCard{
	public GoToJailCard() {
		this.cardValue = 0;
		this.cardDescription = "No luck. Go to jail!!";
	}
	
	public void action(Player p, Square location) {
		super.action(p, location);
		p.setLocation(location);
	}

}
