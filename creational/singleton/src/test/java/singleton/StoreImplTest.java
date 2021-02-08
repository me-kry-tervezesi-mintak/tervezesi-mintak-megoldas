package singleton;

import org.junit.Test;
import singleton.Product;
import singleton.StoreImpl;
import singleton.exception.StoreEmptyException;
import singleton.exception.StoreFullException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.*;

public class StoreImplTest {

	@Test
	public void getInstance() {
		Store store = StoreImpl.getInstance();
		store.reset();
		StoreImpl storeImpl1 = StoreImpl.getInstance();

		assertThat(store, sameInstance(storeImpl1));
	}

	@Test
	public void add() throws StoreFullException {
		StoreImpl store = StoreImpl.getInstance();
		store.reset();

		assertThat(store.getProductCount(), is(0));

		store.add(new Product("name"));

		assertThat(store.getProductCount(), is(1));

	}

	@Test(expected = StoreFullException.class, timeout = 1000)
	public void addTooMuch() throws StoreFullException {
		StoreImpl store = StoreImpl.getInstance();
		store.reset();

		assertThat(store.getProductCount(), is(0));

		for (int i = 0; i < StoreImpl.CAPACITY + 1; i++) {
			store.add(new Product("name"));
		}

		fail();
	}

	@Test(expected = StoreEmptyException.class, timeout = 1000)
	public void removeFromEmptyStore() throws StoreEmptyException {
		StoreImpl store = StoreImpl.getInstance();
		store.reset();

		assertThat(store.getProductCount(), is(0));

		store.remove();

		fail();
	}

	@Test(timeout = 1000)
	public void removeAddRemove() throws StoreEmptyException, StoreFullException {
		StoreImpl store = StoreImpl.getInstance();
		store.reset();

		assertThat(store.getProductCount(), is(0));
		store.add(new Product("name"));
		store.remove();

		assertThat(store.getProductCount(), is(0));
	}

}