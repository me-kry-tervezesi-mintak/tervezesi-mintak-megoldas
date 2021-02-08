package composite;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RobotPartTest {
	@Test
	public void getComplexity() {
		RobotPart robotPart = new RobotPart(5);

		assertThat(robotPart.getComplexity(), is(5));
	}

	@Test
	public void getCount() {
		RobotPart robotPart = new RobotPart(5);

		assertThat(robotPart.getCount(), is(1));
	}

	@Test
	public void getRobotPartCount() {
		RobotPart robotPart = new RobotPart(5);

		assertThat(robotPart.getCount(), is(1));
	}

	@Test
	public void getNamespaceCount() {
		RobotPart robotPart = new RobotPart(5);

		assertThat(robotPart.getNamespaceCount(), is(0));
	}

}