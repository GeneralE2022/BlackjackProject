package com.skilldistillery.com.blackjack;

import java.util.Scanner;

import com.skilldistillery.blackjack.cards.Dealer;
import com.skilldistillery.blackjack.cards.Player;

public class BlackjackApp {
	Scanner sc = new Scanner(System.in);
	Dealer dealer = new Dealer();
	Player player = new Player();

	public static void main(String[] args) {
		BlackjackApp bj = new BlackjackApp();
		bj.run();
	}

	public void run() {
		System.out.println("***** Let's play a game of Blackjack *****");
		System.out.println("shuffling a new deck....");
		dealer.shuffle();
		dealer.dealerTurn();
		dealer.shuffle();
		player.playerTurn();
	}
}
