package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	Deck deck = new Deck();
	List<Card> dealerHand = new ArrayList<>();
	private int dTotalValue;
	private boolean dealerTurn = true;

	public void shuffle() {
		deck.shuffle();
	}

	public void dealerTurn() {
		dTotalValue = 0;
		System.out.println("Dealer's turn...");
		dealerHand.add(dealerInitialDraw());
		dealerHand.add(dealerDraws());

		while (dealerTurn && dTotalValue < 17 && dTotalValue < 21) {
			System.out.print("Dealer draws...");
			dealerDraws();

			if (dTotalValue > 21) {
				System.out.println("You won the game!");
				System.out.println();
				dealerTurn = false;
				break;
			}
		}
	}

	public boolean isDealerTurn() {
		return dealerTurn;
	}

	public void setDealerTurn(boolean dealerTurn) {
		this.dealerTurn = dealerTurn;
	}

	public Card dealerDraws() {
		Card dcard = dealCard();
		dealerHand.add(dcard);
		dTotalValue += dcard.getValue();
		System.out.println("Dealer drew: " + dealerHand.get(dealerHand.size() - 1));
		System.out.println("Dealer's point value: " + dTotalValue);
		return dcard;
	}

	public Card dealerInitialDraw() {
		Card dcard = dealCard();
		dealerHand.add(dcard);
		dTotalValue += dcard.getValue();
		return dcard;
	}

	public Card dealCard() {
		return deck.dealCard();
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public List<Card> getDealerHand() {
		return dealerHand;
	}

	public void setDealerHand(List<Card> dealerHand) {
		this.dealerHand = dealerHand;
	}

	public int getTotalValue() {
		return dTotalValue;
	}

	public void setTotalValue(int totalValue) {
		this.dTotalValue = totalValue;
	}

	public int getdTotalValue() {
		return dTotalValue;
	}

	public void setdTotalValue(int dTotalValue) {
		this.dTotalValue = dTotalValue;
	}

}