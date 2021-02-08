package observer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RowerTest {
	@Test
	public void creation() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Rower rower = new Rower(distanceSensor);

		assertThat(rower.getMinimumDistance(), is(650));
	}

	@Test
	public void moveForwardNotBlocked() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Rower rower = new Rower(distanceSensor);

		assertThat(rower.isMovingForward(), is(false));

		assertThat(rower.moveForward(), is(true));
		assertThat(rower.isMovingForward(), is(true));

	}

	@Test
	public void moveForwardBlocked() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Rower rower = new Rower(distanceSensor);

		assertThat(rower.isMovingForward(), is(false));
		rower.update(12);

		assertThat(rower.moveForward(), is(false));
		assertThat(rower.isMovingForward(), is(false));

	}

	@Test
	public void switchOff() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Rower rower = new Rower(distanceSensor);

		assertThat(rower.isBlocked(), is(false));

		rower.switchOff();

		assertThat(rower.isBlocked(), is(true));
		verify(distanceSensor).unregister(rower);
	}

	@Test
	public void update() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Rower rower = new Rower(distanceSensor);

		rower.update(99);
		assertThat(rower.isBlocked(), is(true));

		rower.update(651);
		assertThat(rower.isBlocked(), is(false));
	}

	@Test
	public void emergencyStop() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Rower rower = new Rower(distanceSensor);

		rower.isMovingForward(); // moving

		rower.update(99);
		assertThat(rower.isBlocked(), is(true));

	}

	@Test
	public void isBlocked() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Rower rower = new Rower(distanceSensor);

		assertThat(rower.isBlocked(), is(false));
	}

}