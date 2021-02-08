package bridge;

public class VisuallyImparedRepresentation implements Representation {
	@Override
	public String getCaption(String itemName) {
		return itemName.toUpperCase();
	}
}
