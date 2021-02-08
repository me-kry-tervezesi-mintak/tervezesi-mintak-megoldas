package immutable.planet;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PointTest {
	@Test
	public void testContructorAndGetters() {
		final long pointX = 123456;
		final long pointY = 2222;
		final long pointZ = 33211;
		Point point = new Point(pointX, pointY, pointZ);
		assertThat(point.getX(), is(pointX));
		assertThat(point.getY(), is(pointY));
		assertThat(point.getZ(), is(pointZ));
	}
}