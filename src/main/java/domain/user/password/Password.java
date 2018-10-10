package domain.user.password;

import org.mindrot.jbcrypt.BCrypt;

public class Password {

	private String passwordDigest;

	public Password(){
	}

	public Password (String password){
		generatePassword(password);
	}


	public void generatePassword(String passwordString ){
		this.passwordDigest = BCrypt.hashpw(passwordString,BCrypt.gensalt());
	}

	public void verify(String passwordString) throws MismatchedPasswordException{

		boolean valid = BCrypt.checkpw(passwordString,passwordDigest);
		if (!valid){
			throw new MismatchedPasswordException();
		}
	}

	public String getPasswordDigest(){
		return  passwordDigest;
	}




}
