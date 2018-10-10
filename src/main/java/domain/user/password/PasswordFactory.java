package domain.user.password;

public class PasswordFactory {

	private PasswordPolicy passwordPolicy;

	public PasswordFactory(PasswordPolicy passwordPolicy) {

		this.passwordPolicy = passwordPolicy;
	}

	public Password create(String goodPassword) throws IllegalPasswordFormatException {

		if (passwordPolicy.isValid(goodPassword)){
			return new Password(goodPassword);
		}
		else{
			throw new IllegalPasswordFormatException();
		}
	}
}
