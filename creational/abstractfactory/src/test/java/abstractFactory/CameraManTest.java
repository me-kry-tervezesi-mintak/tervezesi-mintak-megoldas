package abstractFactory;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by zoltankrizsan on 2017. 02. 02..
 */
public class CameraManTest {
	@Test
	public void createMovie() {
		AbstractAnimalFactory abstractAnimalFactory = mock(AbstractAnimalFactory.class);

		Carnivore carnivore = mock(Carnivore.class);
		when(abstractAnimalFactory.createCarnivore()).thenReturn(carnivore);

		Herbivore herbivore = mock(Herbivore.class);
		when(abstractAnimalFactory.createHerbivore()).thenReturn(herbivore);

		CameraMan cameraMan = new CameraMan(abstractAnimalFactory);

		cameraMan.createMovie();

		verify(abstractAnimalFactory).createCarnivore();
		verify(abstractAnimalFactory).createHerbivore();
		verify(carnivore).eat(herbivore);
	}

}