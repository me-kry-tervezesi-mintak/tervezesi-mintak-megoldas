package proxy;

public class Client {
	private final Log log;

	public Client(Log log) {
		this.log = log;
	}

	public void doStep() {
		log.logRequest("doStep");
	}
}
