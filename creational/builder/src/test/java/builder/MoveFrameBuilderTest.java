package builder;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MoveFrameBuilderTest {

	@Test
	public void buildOnlyOneRotation() {
		MoveFrameBuilder moveFrameBuilder = new MoveFrameBuilder();

		Frame frame = moveFrameBuilder.setRotationSpeed((byte)100).build();
		assertThat(frame.toHex(), is("7D-00-00-64-00-E1"));
	}

	@Test
	public void buildSettingAllValue() {
		MoveFrameBuilder moveFrameBuilder = new MoveFrameBuilder();

		Frame frame = moveFrameBuilder
				.setXSpeed((byte)1)
				.setYSpeed((byte)2)
				.setRotationSpeed((byte)3)
				.setMaximumSpeed((byte)4)
				.build();
		assertThat(frame.toHex(), is("7D-01-02-03-04-87"));
	}

	@Test
	public void buildDefaultValues() {
		Frame frame = new MoveFrameBuilder().build();
		assertThat(frame.toHex(), is("7D-00-00-00-00-7D"));
	}

}