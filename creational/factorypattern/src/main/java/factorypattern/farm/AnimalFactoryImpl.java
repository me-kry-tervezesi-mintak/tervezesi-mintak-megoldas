package factorypattern.farm;

public class AnimalFactoryImpl implements AnimalFactory {
	@Override
	public Animal create(String animalType) {
		Animal animal = null;

		if (animalType != null) {
			switch (animalType) {
				case "cock":
					animal = new Cock();
					break;
				case "horse":
					animal = new Horse();
					break;
				case "frog":
					animal = new Frog();
					break;
			}
		}

		return animal;
	}
}
