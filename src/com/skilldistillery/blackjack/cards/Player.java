package com.skilldistillery.blackjack.cards;

public class Player {

	private Hand hand = new Hand();

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public Hand getHand() {
		return hand;
	}

	public int getHandValue() {
		return hand.getHandValue();
	}

}