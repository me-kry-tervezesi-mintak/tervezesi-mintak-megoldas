package singleton;

import singleton.exception.StoreEmptyException;

public class Consumer {
	private final Store store;

	public Consumer(Store store) {
		this.store = store;
	}

	protected Product consume() throws StoreEmptyException {
		return store.remove();
	}

}
