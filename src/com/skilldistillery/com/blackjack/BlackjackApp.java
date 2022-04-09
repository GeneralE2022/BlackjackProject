package com.skilldistillery.com.blackjack;

import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Dealer;
import com.skilldistillery.blackjack.cards.Player;

public class BlackjackApp {
	Scanner sc = new Scanner(System.in);
	Dealer dealer = new Dealer();
	Player player = new Player();
	private boolean dealerTurn = true;

	public static void main(String[] args) {
		BlackjackApp bj = new BlackjackApp();
		bj.run();
	}

	private void run() {
		// dealer draws 1 card face down
		// player is dealt 1 card
		// dealer draws 1 card face up
		// player is dealt 1 card
		// dealer draws up to 17+ pts -> busts if 21+
		// player draws up to 17+ pts -> busts if 21+
		System.out.println("***** Let's play a game of Blackjack *****");
		System.out.println("Dealer shuffles a new deck....");
		dealer.shuffle();
		dealer.addCard(dealerInitialDraw()); // dealer draws 1 card face down
		System.out.println();
		player.addCard(playerDraws()); // player is dealt 1 card
		System.out.println();
		dealer.addCard(dealerDraws()); // dealer draws 1 card face up
		player.addCard(playerDraws()); // player is dealt 1 card
		System.out.println("\tYour current hand totals: " + player.getHandValue());
		System.out.println();
		dealerTurn();
		playerTurn();
	}

	public void dealerTurn() {

		while (dealer.getHandValue() < 17) {
			dealer.addCard(dealerDraws());

			if (dealer.getHandValue() > 17 && dealer.getHandValue() < 21) {
				System.out.println("Dealer stays.");
//			playerTurn();
			}

			if (dealer.getHandValue() > 21) {
				dBust();
			}
		}
	}

	public void playerTurn() {
		System.out.println();
		System.out.println("Your turn...");

		while (player.getHandValue() < 22) {
			System.out.println("Please choose to (D)raw or (S)tay");
			String input = sc.nextLine();

			switch (input) {
			case "D":
				player.addCard(playerDraws());
				if (player.getHandValue() > 22) {
					pBust();
				}

			case "S":
				if (player.getHandValue() > dealer.getHandValue()) {
					dBust();
				} else if (player.getHandValue() < dealer.getHandValue()) {
					pBust();
				} else {
					tie();
					break;
				}
				break;

			default:
				break;
			}
		}
	}

	public Card dealerInitialDraw() {
		System.out.println("Dealer draws 1 hidden card. ");
		Card card = dealer.dealCard();
		return card;
	}

	public Card dealerDraws() {
		Card card = dealer.dealCard();
		System.out.println("Dealer drew: " + card + " worth " + card.getValue() + " points");
		System.out.println();
		return card;
	}

	public Card playerDraws() {
		Card card = dealer.dealCard();
		System.out.print("\tYou drew: " + card + " worth " + card.getValue() + " points");
		System.out.println();
		return card;
	}

	public void dBust() {
		System.out.println("The dealer lost.");
		dealerTurn = false;
		System.exit(0);
	}

	public void pBust() {
		System.out.println("You lost.");
		System.exit(0);
	}

	public void tie() {
		System.out.println("It's a tie.");
		System.exit(0);
	}
}
