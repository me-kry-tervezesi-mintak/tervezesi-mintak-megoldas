package proxy;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ClientTest {
	@Test
	public void doStep() {
		Log log = mock(Log.class);
		Client client = new Client(log);
		client.doStep();

		verify(log).logRequest("doStep");
	}

}