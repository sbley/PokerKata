package de.saxsys.dojo.poker;

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
}
