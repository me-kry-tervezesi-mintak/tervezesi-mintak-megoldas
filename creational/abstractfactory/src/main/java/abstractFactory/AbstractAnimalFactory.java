package abstractFactory;

/**
 * Created by zoltankrizsan on 2017. 02. 01..
 */
public interface AbstractAnimalFactory {
	Carnivore createCarnivore();
	Herbivore createHerbivore();
}
