package adapter;

public class FileManagerAdapter implements FileManager {
	private final FileManagerUtil fileManagerUtil;

	public FileManagerAdapter(FileManagerUtil fileManagerUtil) {
		this.fileManagerUtil = fileManagerUtil;
	}

	@Override
	public Status open(String filename) {
		if (fileManagerUtil.openFile(filename)) {
			return Status.SUCCESS;
		}

		return Status.FAILED;
	}

	@Override
	public Status close() {
		if (fileManagerUtil.closeFile()) {
			return Status.SUCCESS;
		}

		return Status.FAILED;
	}

	@Override
	public Status read(int offset, int length, byte[] bytes) {
		byte[] result = fileManagerUtil.readFromFile(offset, length).getBytes();

		final int bufferSizeSize = result.length > 1000 ? 1000 : result.length;

		for (int i = 0; i < bufferSizeSize; i++) {
			bytes[i] = result[i];
		}

		return Status.SUCCESS;
	}

	@Override
	public Status write(int offset, int length, byte[] bytes) {
		String text = new String(bytes, (int)offset, (int)length);


		if (fileManagerUtil.writeToFile(text, offset, length)) {
			return Status.SUCCESS;
		}

		return Status.FAILED;
	}
}
