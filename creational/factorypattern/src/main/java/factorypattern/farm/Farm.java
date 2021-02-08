package factorypattern.farm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Farm {
	AnimalFactory animalFactory;
	List<Animal> animals = new ArrayList<>();

	public Farm(AnimalFactory animalFactory) {
		this.animalFactory = animalFactory;
	}

	void newAnimalArrived(String animalType) {
		Animal animal = animalFactory.create(animalType);
		if (animal != null) {
			animals.add(animal);
		}
	}

	List<String> getAnimalVoices() {
		List<String> animalVoices = new ArrayList<>();

		for (Animal animal: animals) {
			String voice = animal.speak();

			if (!animalVoices.contains(voice)) {
				animalVoices.add(voice);
			}
		}

		Collections.sort(animalVoices);
		return animalVoices;
	}

}
