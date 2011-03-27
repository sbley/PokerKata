package de.saxsys.dojo.poker;

import java.util.Arrays;
import java.util.Comparator;

public class Card {
	private static final char[] ranks = new char[] { '2', '3', '4', '5', '6',
			'7', '8', '9', '0', 'J', 'Q', 'K', 'A' };
	private final String card;

	public Card(String card) {
		this.card = card;
		if (-1 == rank()) {
			throw new IllegalArgumentException("Card has unkown value.");
		}
		if (!Arrays.asList('c', 'd', 's', 'h').contains(this.suit())) {
			throw new IllegalArgumentException("Card has unkown suit.");
		}
	}

	public char value() {
		return card.charAt(0);
	}

	public char suit() {
		return card.charAt(1);
	}

	public static Comparator<Card> byValue() {
		return new Comparator<Card>() {

			@Override
			public int compare(Card card1, Card card2) {
				return card1.rank() - card2.rank();
			}
		};
	}

	private int rank() {
		for (int rank = 0; rank < ranks.length; rank++) {
			if (value() == ranks[rank]) {
				return rank;
			}
		}
		return -1;
	}

	public boolean isRankedOneHigher(Card card) {
		return 1 == rank() - card.rank();
	}
}
