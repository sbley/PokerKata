package de.saxsys.dojo.poker;

public class Card {
	private static final char[] ranks = new char[] { '2', '3', '4', '5', '6',
			'7', '8', '9', '0', 'J', 'Q', 'K', 'A' };
	private final String card;

	public Card(String card) {
		this.card = card;
	}

	public char value() {
		return card.charAt(0);
	}

	public char suit() {
		return card.charAt(1);
	}

	private int rank() {
		for (int rank = 0; rank < ranks.length; rank++) {
			if (value() == ranks[rank]) {
				return rank;
			}
		}
		return -1;
	}
}
