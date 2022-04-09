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
	private boolean playerTurn = true;

	public static void main(String[] args) {
		BlackjackApp bj = new BlackjackApp();
		bj.run();
	}

	private void run() {
		System.out.println("***** Let's play a game of Blackjack *****");
		System.out.println("Dealer shuffles a new deck....");
		dealer.shuffle();
		dealer.addCard(dealerInitialDraw()); // dealer draws 1 card face down
//		System.out.println("TESTING: " + dealer.getLastCard().toString());
		System.out.println();
		player.addCard(playerDraws()); // player is dealt 1 card
		System.out.println();
		dealer.addCard(dealerDraws()); // dealer draws 1 card face up
		player.addCard(playerDraws()); // player is dealt 1 card
		System.out.println("\tYour current hand totals: " + player.getHandValue());
		System.out.println();
		dealerTurn();
	}

	public void dealerTurn() {

		while (dealerTurn) {

			if (dealer.getHandValue() < 17) {
				dealer.addCard(dealerDraws());
			}

			else if (dealer.getHandValue() > 17 && dealer.getHandValue() < 21) {
				System.out.println("Dealer stays.");
				dealerTurn = false;
			}

			else {
				dealerTurn = false;
				dBust();
				break;
			}

		}
		playerTurn();
	}

	public void playerTurn() {
		while (playerTurn) {
			System.out.println();
			System.out.println("Your turn...");
			System.out.println("Please choose to (D)raw or (S)tay");
			String input = sc.nextLine();

			switch (input) {
			case "D":
				player.addCard(playerDraws());
				if (player.getHandValue() > 22) {
					pBust();
					break;
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
		System.out.println("\tYou won!");
		dealerTurn = false;
		playerTurn = false;
	}

	public void pBust() {
		System.out.println("\tYou lost.");
		dealerTurn = false;
		playerTurn = false;
	}

	public void tie() {
		System.out.println("\tIt's a tie.");
		dealerTurn = false;
		playerTurn = false;
	}
}
