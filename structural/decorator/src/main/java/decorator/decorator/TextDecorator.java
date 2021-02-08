package decorator.decorator;

import decorator.TextSource;

abstract public class TextDecorator implements TextSource {
	protected final TextSource textSource;

	public TextDecorator(TextSource textSource) {
		this.textSource = textSource;
	}
}
