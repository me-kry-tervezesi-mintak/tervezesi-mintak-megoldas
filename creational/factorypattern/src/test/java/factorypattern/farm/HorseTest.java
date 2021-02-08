package factorypattern.farm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HorseTest {
	@Test
	public void speak() {
		Horse horse = new Horse();
		assertThat(horse.speak(), is("nyihaha"));
	}

}