package factorypattern.farm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FarmComponentTest {

	@Test
	public void getAnimalVoicesWithNull(){
		Farm farm = new Farm(new AnimalFactoryImpl());

		farm.newAnimalArrived(null);

		assertThat(farm.getAnimalVoices().size(), is(0));
	}

	@Test
	public void getAnimalVoicesWithUnknownAnimalName(){
		Farm farm = new Farm(new AnimalFactoryImpl());

		farm.newAnimalArrived("none");

		assertThat(farm.getAnimalVoices().size(), is(0));
	}

	@Test
	public void getAnimalVoicesWithOneFrog(){
		Farm farm = new Farm(new AnimalFactoryImpl());

		farm.newAnimalArrived("frog");

		assertThat(farm.getAnimalVoices().size(), is(1));
		assertThat(farm.getAnimalVoices().get(0), is("brekeke"));
	}

	@Test
	public void getAnimalVoicesWithTwoFrog(){
		Farm farm = new Farm(new AnimalFactoryImpl());

		farm.newAnimalArrived("frog");
		farm.newAnimalArrived("frog");

		assertThat(farm.getAnimalVoices().size(), is(1));
		assertThat(farm.getAnimalVoices().get(0), is("brekeke"));
	}

	@Test
	public void getAnimalVoicesWithOneFrogOneHorse(){
		Farm farm = new Farm(new AnimalFactoryImpl());

		farm.newAnimalArrived("horse");
		farm.newAnimalArrived("frog");

		assertThat(farm.getAnimalVoices().size(), is(2));
		assertThat(farm.getAnimalVoices().get(0), is("brekeke"));
		assertThat(farm.getAnimalVoices().get(1), is("nyihaha"));
	}

	@Test
	public void getAnimalVoicesComplexTest(){
		Farm farm = new Farm(new AnimalFactoryImpl());

		farm.newAnimalArrived("horse");
		farm.newAnimalArrived("frog");
		farm.newAnimalArrived("horse");
		farm.newAnimalArrived("horse");
		farm.newAnimalArrived("cock");
		farm.newAnimalArrived("");

		assertThat(farm.getAnimalVoices().size(), is(3));
		assertThat(farm.getAnimalVoices().get(0), is("brekeke"));
		assertThat(farm.getAnimalVoices().get(1), is("kukuriku"));
		assertThat(farm.getAnimalVoices().get(2), is("nyihaha"));
	}
}