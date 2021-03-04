package hu.bitbot.designpatterns.behavioural.state;

/**
 * Created by zoltankrizsan on 2017. 01. 16..
 */
public class DvdPlayerContext {

	State state;

	int position;

	int length;

	public DvdPlayerContext() {
		setState(new StoppedState(this));
		setPosition(0);
	}

	public synchronized void setState(State state) {
		this.state = state;
	}

	public synchronized int getPosition() {
		return position;
	}

	public synchronized void setPosition(int position) {
		if (position >= 0 && position <= length) {
			this.position = position;
		}
	}

	public synchronized int getLength() {
		return length;
	}

	public synchronized void setLength(int length) {
		this.length = length;
	}

	public void play() {
		state.play();
	}

	public void stop() {
		state.stop();
	}

	public void backward10Frame() {
		state.backward10Frame();
	}

	public void forward10Frame() {
		state.forward10Frame();
	}

	public void pause() {
		state.pause();
	}

	public void spin() {
		state.spin();
	}

	@Override
	public synchronized String toString() {
		return "DvdPlayerContext{" +
				"state=" + state +
				", position=" + position +
				", length=" + length +
				'}';
	}
}
