package bridge;

/**
 * Created by zoltankrizsan on 2017. 02. 20..
 */
public class Character implements Item{
	private final String name;
	private final CharacterType characterType;
	private final Representation representation;

	public Character(String name, CharacterType characterType, Representation representation) {
		this.name = name;
		this.characterType = characterType;
		this.representation = representation;
	}

	@Override
	public String getCaption() {
		return representation.getCaption(name + " (" + characterType + ")");
	}

	public void move()
	{
	}
}
