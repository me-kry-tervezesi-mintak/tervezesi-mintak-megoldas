package decorator.isa;

import decorator.HtmlText;

public class ItalicAndBoldHtmlText extends HtmlText {
	public ItalicAndBoldHtmlText(String plainText) {
		super(plainText);
	}

	@Override
	public String getPlainText() {
		return "<i><b>" + super.getPlainText() + "</b></i>";
	}
}
