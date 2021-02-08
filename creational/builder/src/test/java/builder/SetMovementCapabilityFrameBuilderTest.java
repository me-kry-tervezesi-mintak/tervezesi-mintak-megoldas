package builder;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SetMovementCapabilityFrameBuilderTest {

	@Test
	public void buildDefaultValues() {
		Frame frame = new SetMovementCapabilityFrameBuilder().build();
		assertThat(frame.toHex(), is("04-60-0A-62-08-D8"));
	}

	@Test
	public void buildUsingJustAcceleration() {
		Frame frame = new SetMovementCapabilityFrameBuilder().setMaximumAcceleration((byte)100).build();
		assertThat(frame.toHex(), is("04-60-0A-64-08-DA"));
	}

	@Test
	public void buildSetAll() {
		Frame frame = new SetMovementCapabilityFrameBuilder()
				.setMaximumAcceleration((byte)0)
				.setMaximumRotationalAcceleration((byte)0)
				.setMaximumSpeed((byte)0)
				.setMaximumRotationSpeed((byte)0)
				.build();
		assertThat(frame.toHex(), is("04-00-00-00-00-04"));
	}

}