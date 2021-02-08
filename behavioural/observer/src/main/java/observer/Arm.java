package observer;

public class Arm extends Actuator{

	public Arm(DistanceSensor distanceSensor) {
		super(distanceSensor, 350);
	}

	public boolean lift() {
		return !isBlocked();
	}
}
