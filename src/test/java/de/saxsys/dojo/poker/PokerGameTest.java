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
		PokerGame pokerGame = new PokerGame(new String[] { "2s", "5c", "3h",
				"0h", "Kh" });
		assertThat(pokerGame.getScore(), is(equalTo("highest card")));
	}
}
