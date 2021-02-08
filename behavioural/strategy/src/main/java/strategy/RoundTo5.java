package strategy;


public class RoundTo5 implements RoundStrategy {

	private int getTo5(int from) {
		int ten = from / 10;
		int remainder = from % 10;
		int value = 0;

		if (remainder > 2 && remainder < 8) {
			value = 5;
		} else if (remainder >= 8 ){
			ten++;
		}
		return ten * 10 + value;
	}

	@Override
	public int convert(double from) {
		return getTo5((int)(from + 0.5));
	}
}
