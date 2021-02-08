package bridge;

public class Settlement implements Item{
	private String settlementName;

	private final Representation representation;

	public void setSettlementName(String settlementName) {
		this.settlementName = settlementName;
	}

	public Settlement(Representation representation) {
		this.representation = representation;
	}

	@Override
	public String getCaption() {
		return representation.getCaption(settlementName);
	}
}
