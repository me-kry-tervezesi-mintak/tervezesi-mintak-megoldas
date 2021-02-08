package abstractFactory.america;

import abstractFactory.Carnivore;
import abstractFactory.Herbivore;

/**
 * Created by zoltankrizsan on 2017. 02. 01..
 */
public class Wolf implements Carnivore {
	public void eat(Herbivore herbivore) {
		System.out.println(toString() + "eats the " + herbivore.toString());
	}
}
