package bridge;

public class NormalRepresentation implements Representation {
	@Override
	public String getCaption(String itemName) {
		return itemName.toLowerCase();
	}
}
