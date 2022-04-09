package com.skilldistillery.blackjack.cards;

public class Dealer {

	private Deck deck = new Deck();
	private Hand hand = new Hand();

	public Card dealCard() {
		return deck.dealCard();
	}

	public void addCard(Card card) {
		hand.addCard(card);
	}

	public Deck shuffle() {
		deck.shuffle();
		return deck;
	}

	public Deck getDeck() {
		return deck;
	}

	public Hand getHand() {
		return hand;
	}

	public int getHandValue() {
		return hand.getHandValue();
	}

	public Card getLastCard() {
		return hand.getHand().get(1);
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

}