package factorypattern.farm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FrogTest {
	@Test
	public void speak() {
		Frog frog = new Frog();
		assertThat(frog.speak(), is("brekeke"));
	}

}