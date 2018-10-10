package application.user.service;

import api.user.dto.ClientDto;
import domain.user.UserProfile;

public class UserAssembler {

	public UserProfile assemble(ClientDto clientDto) {

		String name = clientDto.getName();
		String lastName = clientDto.getLastName();
		String nickname = clientDto.getNickname();
		int age = clientDto.getAge();

		return new UserProfile(name,lastName,nickname);
	}
}
