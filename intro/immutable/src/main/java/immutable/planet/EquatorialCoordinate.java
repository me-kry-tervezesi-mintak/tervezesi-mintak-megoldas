package immutable.planet;

public class EquatorialCoordinate {
	final private long longitude;
	final private long azimuth;

	public EquatorialCoordinate(long longitude, long azimuth) {
		this.longitude = longitude;
		this.azimuth = azimuth;
	}

	public long getLongitude() {
		return longitude;
	}

	public long getAzimuth() {
		return azimuth;
	}

}

