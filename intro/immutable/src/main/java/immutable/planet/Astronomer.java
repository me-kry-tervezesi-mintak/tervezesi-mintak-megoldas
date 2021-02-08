package immutable.planet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Astronomer {
	final private String name;
	private InternationalActronomicalUnion internationalActronomicalUnion;
	private List<Planet> discoveredPLanets = new ArrayList<>();
	private PlanetCalculator planetCalculator;

	public Astronomer(String name, InternationalActronomicalUnion internationalActronomicalUnion,
					  PlanetCalculator planetCalculator) {
		this.name = name;
		this.internationalActronomicalUnion = internationalActronomicalUnion;
		this.planetCalculator = planetCalculator;
	}

	public List<Planet> getDiscoveredPLanets() {
		return discoveredPLanets;
	}

	public boolean observeTheSky(Date date, EquatorialCoordinate equatorialCoordinate) {
		boolean rv = true;
		if (!internationalActronomicalUnion.isThePlanetDiscovered(date, equatorialCoordinate)) {
			Point point = internationalActronomicalUnion.getRealPosition(equatorialCoordinate);
			long radius = planetCalculator.getPlanetRadiusInPosition(point);
			Planet newPlanet = new Planet(this.name, radius);
			boolean registrationSuccess = internationalActronomicalUnion.register(newPlanet, point);

			rv = registrationSuccess;

			if (registrationSuccess) {
				discoveredPLanets.add(newPlanet);
			}
		}

		return rv;
	}

}
