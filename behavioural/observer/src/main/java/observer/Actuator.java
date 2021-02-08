package observer;


public class Actuator implements DistanceObserver{
	private final DistanceSensor distanceSensor;
	public final int MINIMUM_DISTANCE;
	private boolean blocked = false;

	protected Actuator(DistanceSensor distanceSensor, int MINIMUM_DISTANCE) {
		distanceSensor.register(this);
		this.distanceSensor = distanceSensor;
		this.MINIMUM_DISTANCE = MINIMUM_DISTANCE;
	}

	protected DistanceSensor getDistanceSensor() {
		return distanceSensor;
	}

	public int getMinimumDistance() {
		return MINIMUM_DISTANCE;
	}

	public boolean isBlocked() {
		return blocked;
	}

	protected void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public void switchOff() {
		blocked = true;
		getDistanceSensor().unregister(this);
	}

	@Override
	public void update(int distance) {
		blocked = MINIMUM_DISTANCE > distance;
	}
}
