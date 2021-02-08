package immutable.planet;

import java.util.Date;

public interface InternationalActronomicalUnion {
	boolean isThePlanetDiscovered(Date noticeDate, EquatorialCoordinate equatorialCoordinate);
	Point getRealPosition(EquatorialCoordinate equatorialCoordinate);
	boolean register(Planet planet, Point position);
}
