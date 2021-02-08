package builder;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;


public class FrameTest {
	@Test
	public void testCreationAndGetter() {
		byte[] bytes = {-1, 0, 1};

		Frame frame = new Frame(bytes);
		assertThat(frame.getBytes(), not(sameInstance(bytes[0])));
		assertThat(frame.getBytes()[0], is(bytes[0]));
		assertThat(frame.getBytes()[1], is(bytes[1]));
		assertThat(frame.getBytes()[2], is(bytes[2]));
	}

	@Test
	public void toHex() {
		byte[] bytes = {-1, 0, 1};

		Frame frame = new Frame(bytes);

		assertThat(frame.toHex(), is("FF-00-01"));
	}

	@Test
	public void toHexWithEmpty() {
		byte[] bytes = {};

		Frame frame = new Frame(bytes);

		assertThat(frame.toHex(), is(""));
	}

	@Test
	public void toHexWithOneByte() {
		byte[] bytes = {1};

		Frame frame = new Frame(bytes);

		assertThat(frame.toHex(), is("01"));
	}

}