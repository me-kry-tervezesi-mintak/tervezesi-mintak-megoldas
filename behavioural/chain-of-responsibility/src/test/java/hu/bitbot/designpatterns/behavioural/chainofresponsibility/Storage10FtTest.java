package hu.bitbot.designpatterns.behavioural.chainofresponsibility;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by zoltankrizsan on 2017. 02. 19..
 */
public class Storage10FtTest {
	@Test
	public void construction() {
		Driver driver = mock(Driver.class);
		Storage10Ft storage10Ft = new Storage10Ft(driver);
	}

	@Test
	public void giveItBack() {
		Driver driver = mock(Driver.class);
		PayBackChain payBackChain = mock(PayBackChain.class);
		ArgumentCaptor<Money> argumentCaptor = ArgumentCaptor.forClass(Money.class);
		Storage10Ft storage10Ft = new Storage10Ft(driver);

		storage10Ft.setNextChain(payBackChain);

		storage10Ft.dispense(new Money(123));

		verify(driver).giveItBack(12);
		verify(payBackChain).dispense(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue().getAmount(), is(3));

	}
}