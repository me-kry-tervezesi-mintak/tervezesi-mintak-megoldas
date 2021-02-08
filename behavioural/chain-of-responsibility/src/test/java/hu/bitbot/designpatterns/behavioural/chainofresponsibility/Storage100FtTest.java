package hu.bitbot.designpatterns.behavioural.chainofresponsibility;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by zoltankrizsan on 2017. 02. 19..
 */
public class Storage100FtTest {
	@Test
	public void construction() {
		Driver driver = mock(Driver.class);
		Storage100Ft storage100Ft = new Storage100Ft(driver);
	}

	@Test
	public void giveItBack() {
		Driver driver = mock(Driver.class);
		PayBackChain payBackChain = mock(PayBackChain.class);
		ArgumentCaptor<Money> argumentCaptor = ArgumentCaptor.forClass(Money.class);
		Storage100Ft storage100Ft = new Storage100Ft(driver);

		storage100Ft.setNextChain(payBackChain);

		storage100Ft.dispense(new Money(123));

		verify(driver).giveItBack(1);
		verify(payBackChain).dispense(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue().getAmount(), is(23));

	}
}