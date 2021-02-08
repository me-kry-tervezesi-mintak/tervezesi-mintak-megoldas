package decorator.decorator;

import decorator.TextSource;

public class TextSourceImplementation implements TextSource {
	String getPlainTextReturnValue;

	public TextSourceImplementation(String getPlainTextReturnValue) {
		this.getPlainTextReturnValue = getPlainTextReturnValue;
	}

	@Override
	public String getPlainText() {
		return getPlainTextReturnValue;
	}
}
