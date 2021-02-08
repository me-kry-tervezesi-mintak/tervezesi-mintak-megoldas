package strategy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RoundTo5Test {
	@Test
	public void convert() {
		RoundTo5 roundTo5 = new RoundTo5();

		assertThat(roundTo5.convert(12.1), is(10));
		assertThat(roundTo5.convert(112), is(110));
		assertThat(roundTo5.convert(227.4), is(225));
		assertThat(roundTo5.convert(227.6), is(230));
	}

}