package immutable.planet;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class EquatorialCoordinateTest {
	@Test
	public void testContructorAndGetters() {
		final long azimuth = 3332123;
		final long longitude = 123456;
		EquatorialCoordinate equatorialCoordinate = new EquatorialCoordinate(longitude, azimuth);
		assertThat(equatorialCoordinate.getAzimuth(), is(azimuth));
		assertThat(equatorialCoordinate.getLongitude(), is(longitude));
	}
}