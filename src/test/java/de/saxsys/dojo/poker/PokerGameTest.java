package de.saxsys.dojo.poker;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PokerGameTest {
	@Test(expected = IllegalArgumentException.class)
	public void init_throwsExceptionIfNoHand() throws Exception {
		new PokerGame(new String[] {});
	}

	@Test(expected = IllegalArgumentException.class)
	public void init_throwsExceptionIfHandHasLessThen5Cards() throws Exception {
		new PokerGame(new String[] { "Kh", "0s", "3c", "3d" });
	}

	@Test(expected = IllegalArgumentException.class)
	public void init_throwsExceptionIfHandHasMoreThen5Cards() throws Exception {
		new PokerGame(new String[] { "Kh", "0s", "3c", "3d", "4h", "Ah" });
	}

	@Test
	public void getScore_highestCard() throws Exception {
		String[] hand = new String[] { "2s", "5c", "3h", "0h", "Kh" };
		assertThat(new PokerGame(hand).getScore(), is(equalTo("highest card")));
	}

	@Test
	public void getScore_flush() throws Exception {
		String[] hand = new String[] { "2h", "5h", "3h", "0h", "Kh" };
		assertThat(new PokerGame(hand).getScore(), is(equalTo("flush")));
	}

	@Test
	public void getScore_straight() throws Exception {
		String[] hand = new String[] { "Ks", "0h", "9d", "Jh", "Qc" };
		assertThat(new PokerGame(hand).getScore(), is(equalTo("straight")));
	}

	@Test
	public void getScore_straightFlush() throws Exception {
		String[] hand = new String[] { "Qs", "0s", "Ks", "Js", "As" };
		assertThat(new PokerGame(hand).getScore(),
				is(equalTo("straight flush")));
	}

	@Test
	public void getScore_fourOfAKind() throws Exception {
		String[] hand = new String[] { "3d", "0s", "3s", "3h", "3c" };
		assertThat(new PokerGame(hand).getScore(),
				is(equalTo("four of a kind")));
	}

	@Test
	public void getScore_threeOfAKind() throws Exception {
		String[] hand = new String[] { "Ad", "0s", "3s", "3h", "3c" };
		assertThat(new PokerGame(hand).getScore(),
				is(equalTo("three of a kind")));
	}
}
