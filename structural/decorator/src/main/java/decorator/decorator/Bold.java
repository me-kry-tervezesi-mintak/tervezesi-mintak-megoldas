package decorator.decorator;

import decorator.TextSource;

public class Bold extends TextDecorator {

	public Bold(TextSource textSource) {
		super(textSource);
	}

	@Override
	public String getPlainText() {
		return "<b>" + textSource.getPlainText() + "</b>";
	}
}
