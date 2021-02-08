package abstractFactory.africa;

import abstractFactory.AbstractAnimalFactory;
import abstractFactory.Carnivore;
import abstractFactory.Herbivore;

/**
 * Created by zoltankrizsan on 2017. 02. 01..
 */
public class AfricaAnimalFactory implements AbstractAnimalFactory{
	public Carnivore createCarnivore() {
		return new Lion();
	}

	public Herbivore createHerbivore() {
		return new Wildebeest();
	}
}
