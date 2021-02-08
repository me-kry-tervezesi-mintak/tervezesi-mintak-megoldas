package decorator.isa;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItalicHtmlTextTest {
	@Test
	public void getBytes() {
		ItalicHtmlText italicHtmlText = new ItalicHtmlText("asd");

		assertThat(italicHtmlText.getPlainText() , is("<i>asd</i>"));
	}

}