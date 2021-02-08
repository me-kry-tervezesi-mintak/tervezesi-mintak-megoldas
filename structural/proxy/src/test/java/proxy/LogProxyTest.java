package proxy;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LogProxyTest {
	@Test
	public void logRequest() {
		final String logMessage = "logmess";

		RealLogger realLogger = mock(RealLogger.class);
		LogProxy logProxy = new LogProxy(realLogger);

		for (int i = 0; i < LogProxy.PAGE_SIZE - 1; i++) {
			logProxy.logRequest(logMessage);
		}

		verify(realLogger, never()).logRequest(logMessage);
	}

	@Test
	public void moreLogRequest() {
		final String logMessage = "logmess";
		List<String> logMessages = new ArrayList<>();
		final String newLine = System.getProperty("line.separator");

		RealLogger realLogger = mock(RealLogger.class);
		LogProxy logProxy = new LogProxy(realLogger);

		for (int i = 0; i < LogProxy.PAGE_SIZE; i++) {
			logProxy.logRequest(logMessage);
			logMessages.add(logMessage);
		}

		verify(realLogger, times(1)).logRequest(
				StringUtils.join(logMessages, newLine)
		);
	}

}