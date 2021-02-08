package decorator.isa;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UnderlinedAndItalicAndBoldHtmlTextTest {
	@Test
	public void getBytes() {
		UnderlinedAndItalicAndBoldHtmlText underlinedAndItalicAndBoldHtmlText = new UnderlinedAndItalicAndBoldHtmlText("asd");

		assertThat(underlinedAndItalicAndBoldHtmlText.getPlainText() , is("<u><i><b>asd</b></i></u>"));
	}

}