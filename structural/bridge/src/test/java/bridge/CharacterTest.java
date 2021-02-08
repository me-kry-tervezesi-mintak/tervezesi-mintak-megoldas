package bridge;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by zoltankrizsan on 2017. 02. 20..
 */
public class CharacterTest {


	@Test
	public void getGeneral() {
		Representation representation = mock(Representation.class);
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		when(representation.getCaption(anyString())).thenReturn("ASDASD");
		Character character = new Character("Logan", CharacterType.Warrior, representation);

		assertThat(character.getCaption(), is("ASDASD"));

		verify(representation).getCaption(argumentCaptor.capture());

		assertThat(argumentCaptor.getValue(), is("Logan (Warrior)"));
	}

	@Test
	public void getCharacterCaptionNormal() {
		Character character = new Character("Logan", CharacterType.Warrior, new NormalRepresentation());

		assertThat(character.getCaption(), is("logan (warrior)"));
	}

	@Test
	public void getCharacterCaptionVisuallyImpared() {
		Character character = new Character("Oz", CharacterType.Wizard, new VisuallyImparedRepresentation());

		assertThat(character.getCaption(), is("OZ (WIZARD)"));
	}
}