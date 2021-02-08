package hu.bitbot.designpatterns.behavioural.chainofresponsibility;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

/**
 * Created by zoltankrizsan on 2017. 02. 19..
 */
public class MoneyTest {

	@Test
	public void construction() {
		Money money = new Money(123);

		assertThat(money.getAmount(), is(123));
	}
}