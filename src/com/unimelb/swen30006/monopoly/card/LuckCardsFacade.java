package com.unimelb.swen30006.monopoly.card;

public class LuckCardsFacade {
	private int Random_Number ;
	public LuckCardsFacade(int Random) {
		this.Random_Number = Random;
	}

	public String getOutcome() {
		// TODO Auto-generated method stub
		
		if(Random_Number == 0) {
			JailExcemptionCard j = new JailExcemptionCard();
			return j.cardDescription;
		} else if(Random_Number == 1 || Random_Number == 2) {
			GoToJailCard  j = new GoToJailCard();
			return j.cardDescription;
			
			
		} else  {
			PayJailFeeCard j  = new PayJailFeeCard(500);
			return j.cardDescription;
		}
	
	
	};
}
