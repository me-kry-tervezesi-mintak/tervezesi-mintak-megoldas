package strategy;

public class YieldProduct extends GeneralProduct {
	public YieldProduct(int ar) {
		super(ar);
	}

	@Override
	protected int round(double newPrice) {
		return (int) newPrice;
	}
}
