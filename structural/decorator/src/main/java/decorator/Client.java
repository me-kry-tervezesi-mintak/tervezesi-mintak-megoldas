package decorator;

public class Client {
	private final Channel channel;

	public Client(Channel channel) {
		this.channel = channel;
	}

	public int writeToChannel(TextSource data) {
		return channel.writeByte(data.getPlainText().getBytes());
	}
}
