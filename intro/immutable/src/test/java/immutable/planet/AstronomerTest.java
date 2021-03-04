package immutable.planet;

import java.util.Date;
import java.util.Random;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

public class AstronomerTest {
	class InternationalActronomicalUnionTestImpl implements InternationalActronomicalUnion {
		boolean isThePlanetDiscoveredReturnValue;
		Point getRealPositionReturnValue;
		boolean registerReturnValue;
		private Planet registeredPlanet;
		private Date noticeDate;
		private Point registeredPlanetPosition;
		private EquatorialCoordinate convertedEquatorialCoordinate;

		public EquatorialCoordinate getConvertedEquatorialCoordinate() {
			return convertedEquatorialCoordinate;
		}

		public Planet getRegisteredPlanet() {
			return registeredPlanet;
		}

		public Point getRegisteredPlanetPosition() {
			return registeredPlanetPosition;
		}

		public InternationalActronomicalUnionTestImpl(boolean isThePlanetDiscoveredReturnValue, Point getRealPositionReturnValue, boolean registerReturnValue) {
			this.isThePlanetDiscoveredReturnValue = isThePlanetDiscoveredReturnValue;
			this.getRealPositionReturnValue = getRealPositionReturnValue;
			this.registerReturnValue = registerReturnValue;
		}

		@Override
		public boolean isThePlanetDiscovered(Date noticeDate, EquatorialCoordinate equatorialCoordinate) {
			this.noticeDate = noticeDate;
			return isThePlanetDiscoveredReturnValue;
		}

		@Override
		public Point getRealPosition(EquatorialCoordinate equatorialCoordinate) {
			convertedEquatorialCoordinate = equatorialCoordinate;
			return getRealPositionReturnValue;
		}

		@Override
		public boolean register(Planet planet, Point position) {
			this.registeredPlanet = planet;
			this.registeredPlanetPosition = position;
			return registerReturnValue;
		}

		public Date getNoticeDate() {
			return noticeDate;
		}
	}

	class PlanetCalculatorImpl implements PlanetCalculator {

		public long getGetPlanetRadiusInPositionReturnValue() {
			return getPlanetRadiusInPositionReturnValue;
		}

		long getPlanetRadiusInPositionReturnValue = new Random().nextLong();
		@Override
		public long getPlanetRadiusInPosition(Point point) {
			return getPlanetRadiusInPositionReturnValue;
		}
	}

	@org.junit.Test
	public void observTheSkyShouldRegisterTheNewPlanet() {
		final String astronomerName = "Galileo";
		final Date observationDate = new Date();
		final Point planetPosition = new Point(10,32,33);

		InternationalActronomicalUnionTestImpl internationalActronomicalUnion = new
				InternationalActronomicalUnionTestImpl(false,
				planetPosition,
				true);
		PlanetCalculatorImpl planetCalculator = new PlanetCalculatorImpl();
		Astronomer astronomer = new Astronomer(astronomerName, internationalActronomicalUnion, planetCalculator);

		EquatorialCoordinate equatorialCoordinate = new EquatorialCoordinate(10,10);

		boolean isNewPlanet = astronomer.observeTheSky(observationDate, equatorialCoordinate);

		assertThat(isNewPlanet, is(true));
		assertThat(internationalActronomicalUnion.getConvertedEquatorialCoordinate(), is(equatorialCoordinate));
		assertThat(internationalActronomicalUnion.getNoticeDate(), is(observationDate));
		assertThat(internationalActronomicalUnion.getRegisteredPlanetPosition(), is(planetPosition));
		assertThat(internationalActronomicalUnion.getRegisteredPlanet().getName(), is(astronomerName));
		assertThat(internationalActronomicalUnion.getRegisteredPlanet().getDiameter(), is(planetCalculator.getPlanetRadiusInPositionReturnValue));
		assertThat(astronomer.getDiscoveredPLanets().size(), is(1));
		assertThat(astronomer.getDiscoveredPLanets().get(0), is(internationalActronomicalUnion.getRegisteredPlanet()));
	}

	@org.junit.Test
	public void observTheSkyShouldNOTRegisterTheNewPlanet() {
		final String astronomerName = "Galileo";
		final Date observationDate = new Date();
		InternationalActronomicalUnionTestImpl internationalActronomicalUnion = new
				InternationalActronomicalUnionTestImpl(true,
				new Point(10,32,33),
				true);
		PlanetCalculatorImpl planetCalculator = new PlanetCalculatorImpl();
		Astronomer astronomer = new Astronomer(astronomerName, internationalActronomicalUnion, planetCalculator);

		EquatorialCoordinate equatorialCoordinate = new EquatorialCoordinate(10,10);
		boolean newPlanet = astronomer.observeTheSky(observationDate, equatorialCoordinate);

		assertThat(newPlanet, is(true));
		assertThat(internationalActronomicalUnion.getNoticeDate(), is(observationDate));
		assertNull(internationalActronomicalUnion.getConvertedEquatorialCoordinate());
		assertNull(internationalActronomicalUnion.getRegisteredPlanetPosition());
		assertNull(internationalActronomicalUnion.getRegisteredPlanet());
		assertThat(astronomer.getDiscoveredPLanets().size(), is(0));
	}

	@org.junit.Test
	public void observTheSkyShouldRegisterTheNewPlanetButFailed() {
		final String astronomerName = "Galileo";
		final Date observationDate = new Date();
		final Point planetPosition = new Point(10,32,33);

		InternationalActronomicalUnionTestImpl internationalActronomicalUnion = new
				InternationalActronomicalUnionTestImpl(false,
				planetPosition,
				false);
		PlanetCalculatorImpl planetCalculator = new PlanetCalculatorImpl();
		Astronomer astronomer = new Astronomer(astronomerName, internationalActronomicalUnion, planetCalculator);

		EquatorialCoordinate equatorialCoordinate = new EquatorialCoordinate(10,10);

		boolean isNewPlanet = astronomer.observeTheSky(observationDate, equatorialCoordinate);

		assertThat(isNewPlanet, is(false));
		assertThat(internationalActronomicalUnion.getConvertedEquatorialCoordinate(), is(equatorialCoordinate));
		assertThat(internationalActronomicalUnion.getNoticeDate(), is(observationDate));
		assertThat(internationalActronomicalUnion.getRegisteredPlanetPosition(), is(planetPosition));
		assertThat(internationalActronomicalUnion.getRegisteredPlanet().getName(), is(astronomerName));
		assertThat(internationalActronomicalUnion.getRegisteredPlanet().getDiameter(), is(planetCalculator.getPlanetRadiusInPositionReturnValue));
		assertThat(astronomer.getDiscoveredPLanets().size(), is(0));
	}
}