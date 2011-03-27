package de.saxsys.dojo.poker;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparisons.greaterThan;
import static org.hamcrest.number.OrderingComparisons.lessThan;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CardTest {
	@Test(expected = IllegalArgumentException.class)
	public void init_throwsExceptionIfHasUnknownValue() throws Exception {
		new Card("Dh");
	}

	@Test(expected = IllegalArgumentException.class)
	public void init_throwsExceptionIfHasUnknownSuit() throws Exception {
		new Card("Qx");
	}

	@Test
	public void value() throws Exception {
		assertThat(new Card("Kh").value(), is(equalTo('K')));
		assertThat(new Card("0c").value(), is(equalTo('0')));
	}

	@Test
	public void suit() throws Exception {
		assertThat(new Card("Kh").suit(), is(equalTo('h')));
		assertThat(new Card("0s").suit(), is(equalTo('s')));
	}

	@Test
	public void byValue() throws Exception {
		assertThat(Card.byValue().compare(new Card("Ks"), new Card("Qc")),
				is(greaterThan(0)));
		assertThat(Card.byValue().compare(new Card("4h"), new Card("5h")),
				is(lessThan(0)));
		assertThat(Card.byValue().compare(new Card("7d"), new Card("7s")),
				is(equalTo(0)));
	}

	@Test
	public void isRankedOneHigher() throws Exception {
		assertThat(new Card("Ah").isRankedOneHigher(new Card("Kd")), is(true));
		assertThat(new Card("Ah").isRankedOneHigher(new Card("Qd")), is(false));
		assertThat(new Card("Qh").isRankedOneHigher(new Card("Qd")), is(false));
	}
}
