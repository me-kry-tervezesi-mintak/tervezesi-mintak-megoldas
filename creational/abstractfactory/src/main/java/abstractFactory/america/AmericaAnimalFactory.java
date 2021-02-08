package abstractFactory.america;

import abstractFactory.AbstractAnimalFactory;
import abstractFactory.Carnivore;
import abstractFactory.Herbivore;

/**
 * Created by zoltankrizsan on 2017. 02. 01..
 */
public class AmericaAnimalFactory implements AbstractAnimalFactory {
	public Carnivore createCarnivore() {
		return new Wolf();
	}

	public Herbivore createHerbivore() {
		return new Bison();
	}
}
