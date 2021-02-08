package decorator.decorator;

import decorator.TextSource;

public class Italic extends TextDecorator {

	public Italic(TextSource textSource) {
		super(textSource);
	}

	@Override
	public String getPlainText() {
		return "<i>" + textSource.getPlainText() + "</i>";
	}
}
