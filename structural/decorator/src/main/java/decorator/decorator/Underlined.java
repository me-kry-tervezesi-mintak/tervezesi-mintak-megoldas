package decorator.decorator;

import decorator.TextSource;

public class Underlined extends TextDecorator {

	public Underlined(TextSource textSource) {
		super(textSource);
	}

	@Override
	public String getPlainText() {
		return "<u>" + textSource.getPlainText() + "</u>";
	}
}
