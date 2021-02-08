package observer;

public interface DistanceSensor {
	void register(DistanceObserver distanceObserver);
	void unregister(DistanceObserver distanceObserver);
}
