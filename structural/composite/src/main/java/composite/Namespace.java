package composite;

import java.util.ArrayList;
import java.util.List;

public class Namespace implements AbstractComponent{
	private final List<AbstractComponent> children = new ArrayList<>();

	public int getChildCount() {
		return children.size();
	}

	public void addChild(AbstractComponent child) {
		if (this.children.contains(child)) {
			return;
		}

		this.children.add(child);
	}

	public void removeChild(AbstractComponent child) {
		this.children.remove(child);
	}

	@Override
	public int getComplexity() {
		int complexity = 0;

		for (AbstractComponent child : children) {
			complexity += child.getComplexity();
		}

		return complexity;
	}

	@Override
	public int getCount() {
		int count = 1;

		for (AbstractComponent child : children) {
			count += child.getCount();
		}

		return count;
	}

	@Override
	public int getRobotPartCount() {
		int robotCount = 0;

		for (AbstractComponent child : children) {
			robotCount += child.getRobotPartCount();
		}

		return robotCount;
	}

	@Override
	public int getNamespaceCount() {
		int namespaceCount = 1;

		for (AbstractComponent child : children) {
			namespaceCount += child.getNamespaceCount();
		}

		return namespaceCount;
	}
}
