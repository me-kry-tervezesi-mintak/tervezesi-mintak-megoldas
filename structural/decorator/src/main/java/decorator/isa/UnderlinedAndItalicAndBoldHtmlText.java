package decorator.isa;

import decorator.HtmlText;

public class UnderlinedAndItalicAndBoldHtmlText extends HtmlText {
	public UnderlinedAndItalicAndBoldHtmlText(String plainText) {
		super(plainText);
	}

	@Override
	public String getPlainText() {
		return "<u><i><b>" + super.getPlainText() + "</b></i></u>";
	}
}
