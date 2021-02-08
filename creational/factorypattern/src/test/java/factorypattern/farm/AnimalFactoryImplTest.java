package factorypattern.farm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class AnimalFactoryImplTest {

	@Test
	public void createCock(){
		AnimalFactory animAnimalFactory = new AnimalFactoryImpl();
		Animal animal = animAnimalFactory.create("cock");

		assertThat(animal, instanceOf(Cock.class));
	}

	@Test
	public void createFrog(){
		AnimalFactory animAnimalFactory = new AnimalFactoryImpl();
		Animal animal = animAnimalFactory.create("frog");

		assertThat(animal, instanceOf(Frog.class));
	}

	@Test
	public void createHorse(){
		AnimalFactory animAnimalFactory = new AnimalFactoryImpl();
		Animal animal = animAnimalFactory.create("horse");

		assertThat(animal, instanceOf(Horse.class));
	}

	@Test
	public void createWithUnknown(){
		AnimalFactory animAnimalFactory = new AnimalFactoryImpl();
		Animal animal = animAnimalFactory.create("aaaaaaa");

		assertNull(animal);
	}

}