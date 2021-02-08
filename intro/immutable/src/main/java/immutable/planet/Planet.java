package immutable.planet;

public class Planet {
	private final String name;
	private final long diameter;

	public String getName() {
		return name;
	}

	public long getDiameter() {
		return diameter;
	}

	public Planet(String name, long diameter) {
		this.name = name;
		this.diameter = diameter;
	}
}
