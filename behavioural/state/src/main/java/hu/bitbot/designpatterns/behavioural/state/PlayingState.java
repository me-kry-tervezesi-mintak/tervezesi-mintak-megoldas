package hu.bitbot.designpatterns.behavioural.state;

/**
 * Created by zoltankrizsan on 2017. 01. 16..
 */
public class PlayingState extends State {
	protected PlayingState(DvdPlayerContext context) {
		super(context);
	}

	public void play() {
		// empty
	}

	public void stop() {
		getContext().setPosition(0);
		getContext().setState(new StoppedState(getContext()));
	}

	public void backward10Frame() {
		throw new UnsupportedOperationException();
	}

	public void forward10Frame() {
		throw new UnsupportedOperationException();
	}

	public void pause() {
		getContext().setState(new StoppedState(getContext()));
	}

	public void spin() {
		getContext().setPosition(getContext().getPosition() +1 );
	}

	@Override
	public String toString() {
		return "PlayingState";
	}
}
