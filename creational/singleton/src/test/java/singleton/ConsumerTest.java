package singleton;

import org.junit.Test;
import singleton.Consumer;
import singleton.Product;
import singleton.Store;
import singleton.exception.StoreEmptyException;
import singleton.exception.StoreFullException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ConsumerTest {
	class StoreImpl implements Store {


		private Product removeReturnValue = new Product("testProduct");

		@Override
		public void add(Product product) {
		}

		@Override
		public Product remove() {
			return removeReturnValue;
		}

		@Override
		public void reset() {

		}

		@Override
		public int getProductCount() {
			return 0;
		}

		public Product getRemoveReturnValue() {
			return removeReturnValue;
		}
	}

	@Test
	public void consume() throws StoreEmptyException {
		StoreImpl store = new StoreImpl();

		Consumer consumer = new Consumer(store);

		Product product = consumer.consume();

		assertThat(store.getRemoveReturnValue().getName(), is("testProduct"));
		assertThat(product.getName(), is("testProduct"));
	}

}