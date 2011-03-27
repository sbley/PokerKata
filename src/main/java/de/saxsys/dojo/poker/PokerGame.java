package de.saxsys.dojo.poker;

public class PokerGame {

	public PokerGame(String[] hand) {
		if (null == hand || 5 != hand.length) {
			throw new IllegalArgumentException(
					"Must provide a hand with 5 cards.");
		}
	}

	public String getScore() {
		return "highest card";
	}

}
