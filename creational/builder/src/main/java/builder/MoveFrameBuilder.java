package builder;

public class MoveFrameBuilder {
	private final byte[] bytes = new byte[6];

	public MoveFrameBuilder() {
		bytes[0] = 125;
	}

	public MoveFrameBuilder setXSpeed(byte speed) {
		bytes[1] = speed;

		return this;
	}

	public MoveFrameBuilder setYSpeed(byte speed) {
		bytes[2] = speed;

		return this;
	}

	public MoveFrameBuilder setRotationSpeed(byte speed) {
		bytes[3] = speed;

		return this;
	}

	public MoveFrameBuilder setMaximumSpeed(byte speed) {
		bytes[4] = speed;

		return this;
	}

	public Frame build() {
		bytes[5] = checksum();

		return new Frame(bytes);
	}

	private byte checksum() {
		byte checksum = 0;
		for (byte aByte : bytes) {
			checksum += aByte;
		}
		return checksum;
	}
}
