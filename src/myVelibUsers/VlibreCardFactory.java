package myVelibUsers;

public class VlibreCardFactory implements CardFactory {
	
	static VlibreCardFactory instance = new VlibreCardFactory();
	
	static public VlibreCardFactory getinstance() {
		return instance;
		
	}
	@Override
	public Card createCard() {
		
		return new VlibreCard();
		
	}

}
