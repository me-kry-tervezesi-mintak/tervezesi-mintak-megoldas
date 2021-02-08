package builder;

public class Frame {
	private final byte[] bytes;

	public Frame(byte[] bytes) {
		this.bytes = bytes;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public String toHex() {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			if (sb.length() != 0) {
				sb.append("-");
			}
			sb.append(String.format("%02X", b));
		}

		return sb.toString();
	}
}
