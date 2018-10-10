package domain.user;

public class BobFactory {
	public Bob create(String name, int age, String adress) {
		return new Bob(name,age,adress);
	}
}
