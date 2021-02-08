package strategy;

public class Product {

	private int price;

	private RoundStrategy strategy;

	public Product(int price, RoundStrategy strategy) {
		this.price = price;
		this.strategy = strategy;
	}

	public int getPrice() {
		return price;
	}

	public int increase(double percent) {
		price = strategy.convert(price + price * (percent / 100));

		return price;
	}

	public void setStrategy(RoundStrategy strategy) {
		this.strategy = strategy;
	}
}
