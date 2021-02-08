package singleton;

import singleton.exception.StoreFullException;

public class Producer {

	private final Store store;
	private int productNumber;

	public Producer(Store store) {
		this.store = store;
	}

	public Product produce() throws StoreFullException {
		Product product = new Product("product" + productNumber++);
		store.add(product);
		return product;
	}

}
