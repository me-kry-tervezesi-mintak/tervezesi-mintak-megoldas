package observer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ArmTest {

	@Test
	public void creation() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Arm arm = new Arm(distanceSensor);

		assertThat(arm.getMinimumDistance(), is(350));
	}

	@Test
	public void lift() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Arm arm = new Arm(distanceSensor);
		arm.update(100);

		assertThat(arm.lift(), is(false));
	}


	@Test
	public void switchOff() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Arm arm = new Arm(distanceSensor);

		assertThat(arm.isBlocked(), is(false));

		arm.switchOff();

		assertThat(arm.isBlocked(), is(true));
		verify(distanceSensor).unregister(arm);
	}

	@Test
	public void update() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Arm arm = new Arm(distanceSensor);

		arm.update(99);
		assertThat(arm.isBlocked(), is(true));

		arm.update(351);
		assertThat(arm.isBlocked(), is(false));
	}

	@Test
	public void isBlocked() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Arm arm = new Arm(distanceSensor);

		assertThat(arm.isBlocked(), is(false));
	}

}