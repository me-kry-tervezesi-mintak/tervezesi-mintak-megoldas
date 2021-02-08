package strategy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BankProductTest {

	@Test
	public void testIncreaseWhenLoan() {
		GeneralProduct termek = new LoanProduct(1);
		termek.increase(50);
		assertThat(termek.getPrice(), is(2));
	}

	@Test
	public void testIncreaseWhenYield() {
		GeneralProduct termek = new YieldProduct(1);
		termek.increase(50);
		assertThat(termek.getPrice(), is(1));
	}
}