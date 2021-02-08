package strategy;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProductTest {
	@Test
	public void getPriceRound() {
		Round round = new Round();
		assertThat( new Product(100, round).increase(23), is(123));
	}

	@Test
	public void getPriceRound5() {
		RoundTo5 round5 = new RoundTo5();
		assertThat( new Product(100, round5).increase(23), is(125));
	}

}