package composite;

public class RobotPart implements AbstractComponent{
	private final int complexity;

	public RobotPart(int complexity) {
		this.complexity = complexity;
	}

	@Override
	public int getComplexity() {
		return complexity;
	}

	@Override
	public int getCount() {
		return 1;
	}

	@Override
	public int getRobotPartCount() {
		return 1;
	}

	@Override
	public int getNamespaceCount() {
		return 0;
	}
}
