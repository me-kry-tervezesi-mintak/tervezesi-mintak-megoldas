package factorypattern.farm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CockTest {
	@Test
	public void speak() {
		Cock cock = new Cock();
		assertThat(cock.speak(), is("kukuriku"));
	}

}