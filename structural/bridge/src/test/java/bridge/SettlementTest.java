package bridge;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SettlementTest {

	@Test
	public void getGeneral() {
		Representation representation = mock(Representation.class);
		ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
		when(representation.getCaption(anyString())).thenReturn("ASDASD");
		Settlement settlement = new Settlement(representation);
		settlement.setSettlementName("Miskolc");

		assertThat(settlement.getCaption(), is("ASDASD"));

		verify(representation).getCaption(argumentCaptor.capture());

		assertThat(argumentCaptor.getValue(), is("Miskolc"));
	}
	@Test
	public void getSettlelentCaptionNormal() {
		Settlement settlement = new Settlement(new NormalRepresentation());

		settlement.setSettlementName("Miskolc");
		assertThat(settlement.getCaption(), is("miskolc"));
	}

	@Test
	public void getSettlelentCaptionVisuallyImpared() {
		Settlement settlement = new Settlement(new VisuallyImparedRepresentation());

		settlement.setSettlementName("Miskolc");
		assertThat(settlement.getCaption(), is("MISKOLC"));
	}
}