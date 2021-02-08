package immutable.planet;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PlanetTest {
	@Test
	public void testContructorAndGetters() {
		final String planetName = "name";
		final long planetDiameter = 123456;
		Planet planet = new Planet(planetName, planetDiameter);
		assertThat(planet.getName(), is(planetName));
		assertThat(planet.getDiameter(), is(planetDiameter));
	}
}