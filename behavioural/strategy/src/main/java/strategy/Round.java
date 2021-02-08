package strategy;

public class Round implements RoundStrategy {
	@Override
	public int convert(double from) {
		return (int)(from + 0.5);
	}
}
