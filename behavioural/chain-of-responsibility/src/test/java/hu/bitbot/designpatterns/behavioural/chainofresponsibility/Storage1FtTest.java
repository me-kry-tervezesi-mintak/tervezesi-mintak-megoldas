package hu.bitbot.designpatterns.behavioural.chainofresponsibility;

import org.junit.Test;
import org.mockito.internal.verification.Times;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by zoltankrizsan on 2017. 02. 19..
 */
public class Storage1FtTest {

	@Test
	public void construction() {
		Driver driver = mock(Driver.class);
		Storage1Ft storage1Ft = new Storage1Ft(driver);
	}

	@Test
	public void giveItBack() {
		Driver driver = mock(Driver.class);
		PayBackChain payBackChain = mock(PayBackChain.class);
		Storage1Ft storage1Ft = new Storage1Ft(driver);

		storage1Ft.setNextChain(payBackChain);

		storage1Ft.dispense(new Money(123));

		verify(driver).giveItBack(123);
	}
}