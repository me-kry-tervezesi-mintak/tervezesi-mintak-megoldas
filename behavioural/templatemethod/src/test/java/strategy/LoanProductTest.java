package strategy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LoanProductTest {
	@Test
	public void round(){
		LoanProduct loanProduct = new LoanProduct(123);
		assertThat(loanProduct.round(1.5), is(2));
	}

}