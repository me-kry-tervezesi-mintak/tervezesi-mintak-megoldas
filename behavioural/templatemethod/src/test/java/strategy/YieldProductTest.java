package strategy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class YieldProductTest {
	@Test
	public void round() {
		YieldProduct yieldProduct = new YieldProduct(123);
		assertThat(yieldProduct.round(1.5), is(1));
	}

}