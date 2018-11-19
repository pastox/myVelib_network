package myVelibUsers;

public class VmaxCardFactory implements CardFactory {
	
	public static VmaxCardFactory instance = new VmaxCardFactory();
	
	public static VmaxCardFactory getinstance() {
		return instance;
	}
	@Override
	public Card createCard() {
		
		return new VmaxCard();
		
	}

}
