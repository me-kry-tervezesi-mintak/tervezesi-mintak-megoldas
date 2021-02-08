package strategy;

public class LoanProduct extends GeneralProduct {
	public LoanProduct(int ar) {
		super(ar);
	}

	@Override
	protected int round(double newPrice) {
		return (int)(newPrice + 0.5);
	}
}
