package hu.bitbot.designpatterns.behavioural.state;

/**
 * Created by zoltankrizsan on 2017. 01. 16..
 */
public class StoppedState extends State {
	public static int STEP = 10;

	protected StoppedState(DvdPlayerContext context) {
		super(context);
	}

	public void play() {
		getContext().setState(new PlayingState(getContext()));
	}

	public void stop() {
		getContext().setPosition(0);
	}

	public void forward10Frame() {
		getContext().setPosition(getContext().getPosition() + STEP);
	}

	public void backward10Frame() {
		getContext().setPosition(getContext().getPosition() - STEP);
	}

	public void pause() {
		//empty
	}

	public void spin() {
		//empty
	}

	@Override
	public String toString() {
		return "StoppedState";
	}
}
