package domain.user;

import domain.user.password.Password;

public class UserProfile {
	private String name;
	private String lastName;
	private String nickName;
	private Password password;
	private int age;

	public UserProfile(String name, String lastName, String nickName) {
		this.name = name;
		this.lastName = lastName;
		this.nickName = nickName;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNickName() {
		return nickName;
	}


	public int getAge() {
		return age;
	}

}
