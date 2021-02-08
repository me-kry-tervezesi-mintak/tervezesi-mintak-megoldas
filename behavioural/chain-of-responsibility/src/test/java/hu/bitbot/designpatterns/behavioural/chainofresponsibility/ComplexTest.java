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
public class ComplexTest {

	@Test
	public void giveItBack() {
		Driver driver100 = mock(Driver.class);
		Driver driver10 = mock(Driver.class);
		Driver driver1 = mock(Driver.class);

		Storage100Ft storage100Ft = new Storage100Ft(driver100);
		Storage10Ft storage10Ft = new Storage10Ft(driver10);
		Storage1Ft storage1Ft = new Storage1Ft(driver1);

		storage100Ft.setNextChain(storage10Ft);
		storage10Ft.setNextChain(storage1Ft);

		storage100Ft.dispense(new Money(523));

		verify(driver100).giveItBack(5);
		verify(driver10).giveItBack(2);
		verify(driver1).giveItBack(3);
	}
}