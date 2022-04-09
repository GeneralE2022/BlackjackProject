package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private int handValue;

	private List<Card> handOfCards;

	public Hand() {
		this.handOfCards = new ArrayList<>();
	}

	public void addCard(Card card) {
		handOfCards.add(card);
		handValue = getHandValue();
	}

	public List<Card> getHand() {
		return handOfCards;
	}

	public int getHandValue() {
		handValue = 0;
		for (Card card : handOfCards) {
			handValue += card.getValue();
		}
		return handValue;
	}

	public void setHandValue(int handValue) {
		this.handValue = handValue;
	}

	public void setHand(List<Card> hand) {
		this.handOfCards = hand;
	}
}
