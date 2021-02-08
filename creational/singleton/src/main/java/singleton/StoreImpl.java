package singleton;

import singleton.exception.StoreEmptyException;
import singleton.exception.StoreFullException;

import java.util.LinkedList;
import java.util.Queue;

public class StoreImpl implements Store{
	private final Queue<Product> products;
	public static final int CAPACITY = 3000;
	private static StoreImpl instance;

	private StoreImpl() {
		this.products = new LinkedList<>();
	}

	public static StoreImpl getInstance() {
		if (instance == null) {
			instance = new StoreImpl();
		}

		return instance;
	}

	public void reset() {
		products.clear();
	}

	@Override
	public void add(Product product) throws StoreFullException {

		if (products.size() >= CAPACITY) {
			throw new StoreFullException();
		}

		this.products.add(product);
	}

	@Override
	public Product remove() throws StoreEmptyException {

		if (products.isEmpty()) {
			throw new StoreEmptyException();
		}

		Product product = this.products.remove();
		return product;
	}

	@Override
	public int getProductCount() {
		return products.size();
	}
}
