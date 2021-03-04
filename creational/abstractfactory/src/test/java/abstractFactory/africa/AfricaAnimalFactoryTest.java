package abstractFactory.africa;

import abstractFactory.Carnivore;
import abstractFactory.Herbivore;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Created by zoltankrizsan on 2017. 02. 02..
 */
public class AfricaAnimalFactoryTest {
	@Test
	public void createCarnivore() {
		assertThat(new AfricaAnimalFactory().createCarnivore(), instanceOf(Carnivore.class));
	}

	@Test
	public void createHerbivore() {
		assertThat(new AfricaAnimalFactory().createHerbivore(), instanceOf(Herbivore.class));
	}

}