package abstractFactory.america;

import abstractFactory.Carnivore;
import abstractFactory.Herbivore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class AmericaAnimalFactoryTest {

    @Test
    public void createCarnivore() {
        assertThat(new AmericaAnimalFactory().createCarnivore(), instanceOf(Carnivore.class));
    }

    @Test
    public void createHerbivore() {
        assertThat(new AmericaAnimalFactory().createHerbivore(), instanceOf(Herbivore.class));
    }
}