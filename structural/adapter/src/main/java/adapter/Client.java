package adapter;

public class Client {
	private final FileManager fileManager;

	public Client(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public boolean write(String filename, String content) {
		boolean rv = false;
		if (fileManager.open(filename) == Status.SUCCESS) {
			rv = fileManager.write(0, content.length(), content.getBytes()) == Status.SUCCESS;
			rv = fileManager.close() == Status.SUCCESS && rv;

		}
		return rv;
	}

	public byte[] read(String filename, int length) {
		byte[] bytes = null;
		if (fileManager.open(filename) == Status.SUCCESS) {
			bytes = new byte[length];
			fileManager.read(0, length, bytes);
			fileManager.close();
		}

		return bytes;
	}
}
