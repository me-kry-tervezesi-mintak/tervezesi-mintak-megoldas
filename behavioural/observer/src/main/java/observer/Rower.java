package observer;

public class Rower extends Actuator{
	boolean movingForward = false;

	public Rower(DistanceSensor distanceSensor) {
		super(distanceSensor, 650);
	}

	@Override
	public void update(int distance) {
		super.update(distance);

		if (isBlocked() && movingForward) {
			emergencyStop();
		}
	}

	public boolean isMovingForward() {
		return movingForward;
	}

	public boolean moveForward() {
		if (!isBlocked()) {
			movingForward = true;
			return true;
		}

		return false;
	}

	private void emergencyStop(){
		movingForward = false;
	}

}
