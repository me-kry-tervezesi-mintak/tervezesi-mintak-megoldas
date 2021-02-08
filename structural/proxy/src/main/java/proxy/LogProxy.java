package proxy;


import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class LogProxy implements Log {

	private final RealLogger logger;
	private final List<String> logMessages = new ArrayList<>();

	public static final int PAGE_SIZE = 10;

	public LogProxy(RealLogger logger) {
		this.logger = logger;
	}

	@Override
	public void logRequest(String message) {
		if (this.logMessages.size() + 1 == PAGE_SIZE) {
			addLogMessage(message);
			performLogging();
		}
		else {
			addLogMessage(message);
		}
	}

	private void addLogMessage(String logMessage) {
		this.logMessages.add(logMessage);
	}

	private void performLogging() {
		final String newLine = System.getProperty("line.separator");
		String message = StringUtils.join(this.logMessages, newLine);

		this.logger.logRequest(message);

		this.logMessages.clear();
	}
}
