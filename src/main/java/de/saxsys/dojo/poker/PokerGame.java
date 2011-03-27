package de.saxsys.dojo.poker;

import java.util.ArrayList;
import java.util.Collections;
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
		boolean flush = isFlush();
		boolean straight = isStraight();
		if (flush && straight) {
			return "straight flush";
		}
		if (flush) {
			return "flush";
		}
		if (straight) {
			return "straight";
		}
		return "highest card";
	}

	private boolean isStraight() {
		sortCards();
		for (int cardIndex = 1; cardIndex < cards.size(); cardIndex++) {
			if (!cards.get(cardIndex).isRankedOneHigher(
					cards.get(cardIndex - 1))) {
				return false;
			}
		}
		return true;
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

	private void sortCards() {
		Collections.sort(cards, Card.byValue());
	}
}
