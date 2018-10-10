package domain.user;

public class UserProfileFactory {
	public UserProfile create(String name, String lastName, String nickname) {
		return new UserProfile(name,lastName,nickname);
	}
}
