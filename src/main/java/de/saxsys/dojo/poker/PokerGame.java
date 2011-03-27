package de.saxsys.dojo.poker;

import java.util.ArrayList;
import java.util.List;

public class PokerGame {

	List<Card> cards;

	public PokerGame(String[] hand) {
		if (null == hand || 5 != hand.length) {
			throw new IllegalArgumentException(
					"Must provide a hand with 5 cards.");
		}
		initCardList(hand);
	}

	public String getScore() {
		if (isFlush()) {
			return "flush";
		}
		return "highest card";
	}

	private boolean isFlush() {
		Character suit = null;
		for (Card card : cards) {
			if (null == suit) {
				suit = card.suit();
			}
			if (suit != card.suit()) {
				return false;
			}
		}
		return true;
	}

	private void initCardList(String[] hand) {
		cards = new ArrayList<Card>(5);
		for (String card : hand) {
			cards.add(new Card(card));
		}
	}
}
