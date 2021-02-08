package abstractFactory;

/**
 * Created by zoltankrizsan on 2017. 02. 01..
 */
public class CameraMan {
	private final AbstractAnimalFactory abstractAnimalFactory;

	public CameraMan(AbstractAnimalFactory abstractAnimalFactory) {
		this.abstractAnimalFactory = abstractAnimalFactory;
	}

	public void createMovie() {
		Carnivore carnivore = abstractAnimalFactory.createCarnivore();
		Herbivore herbivore = abstractAnimalFactory.createHerbivore();

		carnivore.eat(herbivore);
	}
}
