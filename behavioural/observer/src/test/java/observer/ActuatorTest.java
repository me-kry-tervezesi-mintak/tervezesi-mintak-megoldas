package observer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ActuatorTest {
	class ValidActuator extends Actuator {
		public ValidActuator(DistanceSensor distanceSensor, int MINIMUM_DISTANCE) {
			super(distanceSensor, MINIMUM_DISTANCE);
		}
	}

	@Test
	public void getDistanceSersor() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Actuator actuator = new ValidActuator(distanceSensor, 100);

		assertThat(actuator.getDistanceSensor(), is(distanceSensor));
	}



	@Test
	public void setBlocked() {
		DistanceSensor distanceSensor = mock(DistanceSensor.class);
		Actuator actuator = new ValidActuator(distanceSensor, 100);

		assertThat(actuator.isBlocked(), is(false));

		actuator.setBlocked(true);

		assertThat(actuator.isBlocked(), is(true));
	}



}