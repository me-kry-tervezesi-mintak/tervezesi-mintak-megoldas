package hu.bitbot.designpatterns.behavioural.state;

/**
 * Created by zoltankrizsan on 2017. 01. 16..
 */
public abstract class State {

	private final DvdPlayerContext context;

	protected State(DvdPlayerContext context) {
		this.context = context;
	}

	protected DvdPlayerContext getContext() {
		return context;
	}

	public abstract void play();
	public abstract void stop();
	public abstract void backward10Frame();
	public abstract void forward10Frame();
	public abstract void pause();
	public abstract void spin();
	public abstract String toString();
}
