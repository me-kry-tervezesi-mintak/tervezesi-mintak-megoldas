package singleton;

import org.junit.Test;
import singleton.Producer;
import singleton.Product;
import singleton.Store;
import singleton.exception.StoreEmptyException;
import singleton.exception.StoreFullException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ProducerTest {
	class StoreImpl implements Store {

		private Product addParam;

		@Override
		public void add(Product product) {
			addParam = product;
		}

		@Override
		public Product remove() {
			return null;
		}

		@Override
		public void reset() {

		}

		@Override
		public int getProductCount() {
			return 0;
		}

		public Product getAddParam() {
			return addParam;
		}
	}
	@Test
	public void produce() throws StoreFullException {
		StoreImpl store = new StoreImpl();
		Producer producer = new Producer(store);

		Product product = producer.produce();

		assertThat(store.getAddParam().getName() , is("product0"));
		assertThat(product.getName() , is("product0"));
	}
}