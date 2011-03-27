package de.saxsys.dojo.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		if (isFourOfAKind()) {
			return "four of a kind";
		}
		if (flush) {
			return "flush";
		}
		if (straight) {
			return "straight";
		}
		if (isFullHouse()) {
			return "full house";
		}
		if (isThreeOfAKind()) {
			return "three of a kind";
		}
		if (isTwoPairs()) {
			return "two pairs";
		}
		if (isOnePair()) {
			return "one pair";
		}
		return "highest card";
	}

	private boolean isFullHouse() {
		return valueCounts().containsValue(3) && valueCounts().containsValue(2);
	}

	private boolean isFourOfAKind() {
		return valueCounts().containsValue(4);
	}

	private boolean isThreeOfAKind() {
		return valueCounts().containsValue(3);
	}

	private boolean isTwoPairs() {
		int pairs = 0;
		for (Integer value : valueCounts().values()) {
			if (2 == value && ++pairs == 2) {
				return true;
			}
		}
		return false;
	}

	private boolean isOnePair() {
		return valueCounts().containsValue(2);
	}

	private Map<Character, Integer> valueCounts() {
		Map<Character, Integer> valueCounts = new HashMap<Character, Integer>();

		for (Card card : cards) {
			char value = card.value();
			if (null == valueCounts.get(value)) {
				valueCounts.put(value, 1);
			} else {
				valueCounts.put(value, valueCounts.get(value) + 1);
			}
		}
		return valueCounts;
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
