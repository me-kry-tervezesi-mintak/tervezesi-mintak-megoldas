package observer;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DistanceSensorImplTest {

	@Test
	public void creation() {
		DistanceSensorImpl distanceSersor = new DistanceSensorImpl();

		assertThat(distanceSersor.getnumberOfObservers() , is(0));
	}

	@Test
	public void register() {
		DistanceSensorImpl distanceSersor = new DistanceSensorImpl();
		DistanceObserver distanceObserver = mock(DistanceObserver.class);

		distanceSersor.register(distanceObserver);
		assertThat(distanceSersor.getnumberOfObservers() , is(1));
	}

	@Test
	public void unregister() {
		DistanceSensorImpl distanceSersor = new DistanceSensorImpl();
		DistanceObserver distanceObserver = mock(DistanceObserver.class);

		distanceSersor.register(distanceObserver);
		assertThat(distanceSersor.getnumberOfObservers() , is(1));
		distanceSersor.unregister(distanceObserver);
		assertThat(distanceSersor.getnumberOfObservers() , is(0));
	}

	@Test
	public void simulateDataWithEmptyList() {
		DistanceSensorImpl distanceSersor = new DistanceSensorImpl();
		distanceSersor.simulateData(2);
	}

	@Test
	public void simulateData() {
		final int distance = 100;
		DistanceSensorImpl distanceSersor = new DistanceSensorImpl();
		DistanceObserver distanceObserver = mock(DistanceObserver.class);
		DistanceObserver distanceObserver1 = mock(DistanceObserver.class);
		distanceSersor.register(distanceObserver);
		distanceSersor.register(distanceObserver1);

		distanceSersor.simulateData(distance);
		verify(distanceObserver, times(1)).update(distance);
		verify(distanceObserver1, times(1)).update(distance);
	}

}