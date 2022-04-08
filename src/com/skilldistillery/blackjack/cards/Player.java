package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
	Scanner sc = new Scanner(System.in);
	Dealer dealer = new Dealer();
	List<Card> playerHand = new ArrayList<>(0);
	private int pTotalValue = 0;
	boolean playerTurn = true;

	public void playerTurn() {
		while (playerTurn) {
			System.out.println();
			System.out.println("Your turn...");

			playerHand.add(playerInitialDraw());

			playerDraws();

			if (pTotalValue > 21) {
				System.out.println("You lose");
				break;
			} else if (pTotalValue < 22) {
				System.out.println("Please choose to (D)raw or (S)tay");
				String input = sc.nextLine();

				switch (input) {
				case "D":
					playerTurn();
					break;

				case "S":
					if (pTotalValue > dealer.getTotalValue() && pTotalValue < 22) {
						System.out.println("You won!");
					} else {
						System.out.println("The dealer won.");
					}
					break;

				default:
					break;
				}
				playerTurn = false;
				break;
			} else {
				System.out.println("Dealer's point value: " + dealer.getdTotalValue());
				System.out.println("You beat the house this time.");
			}
		}
	}

	public Card playerDraws() {
		Card card = dealer.dealCard();
		playerHand.add(card);
		pTotalValue += card.getValue();
		System.out.println("You drew: " + playerHand.get(playerHand.size() - 1));
		System.out.println("Your point value: " + pTotalValue);

		return card;
	}

	public Card playerInitialDraw() {
		Card card = dealer.dealCard();
		playerHand.add(card);
		pTotalValue += card.getValue();
		return card;
	}

	public int getpTotalValue() {
		return pTotalValue;
	}

	public void setpTotalValue(int pTotalValue) {
		this.pTotalValue = pTotalValue;
	}

}