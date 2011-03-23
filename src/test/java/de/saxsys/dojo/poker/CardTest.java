package de.saxsys.dojo.poker;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CardTest {
	@Test
	public void value() throws Exception {
		assertThat(new Card("Kh").value(), is(equalTo('K')));
		assertThat(new Card("0b").value(), is(equalTo('0')));
	}

	@Test
	public void suit() throws Exception {
		assertThat(new Card("Kh").suit(), is(equalTo('h')));
		assertThat(new Card("0b").suit(), is(equalTo('b')));
	}
}
