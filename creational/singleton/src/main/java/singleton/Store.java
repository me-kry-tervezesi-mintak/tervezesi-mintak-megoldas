package singleton;

import singleton.exception.StoreEmptyException;
import singleton.exception.StoreFullException;

public interface Store {
	void add(Product product) throws StoreFullException;
	Product remove() throws StoreEmptyException;
	void reset();
	int getProductCount();
}
