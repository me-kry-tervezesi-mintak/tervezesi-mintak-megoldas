package observer;

import java.util.ArrayList;
import java.util.List;

public class DistanceSensorImpl implements DistanceSensor {
	private final List<DistanceObserver> distanceObservers = new ArrayList<>();

	@Override
	public void register(DistanceObserver distanceObserver) {
		distanceObservers.add(distanceObserver);
	}

	@Override
	public void unregister(DistanceObserver distanceObserver) {
		distanceObservers.remove(distanceObserver);
	}

	public int getnumberOfObservers() {
		return distanceObservers.size();
	}

	public void simulateData(int data) {
		for (DistanceObserver distanceObserver: distanceObservers) {
			distanceObserver.update(data);
		}
	}


}
