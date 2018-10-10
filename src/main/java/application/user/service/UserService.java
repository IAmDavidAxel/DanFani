package application.user.service;

import api.user.dto.ClientDto;
import domain.user.UserProfile;
import domain.user.UserRepository;

public class UserService {


	private final UserAssembler userAssembler;
	private final UserRepository userRepository;

	public UserService(UserAssembler userAssembler, UserRepository userRepository) {

		this.userAssembler = userAssembler;
		this.userRepository = userRepository;
	}

	public void create(ClientDto clientDto) {

		UserProfile userProfile = userAssembler.assemble(clientDto);

		userRepository.save(userProfile);
	}
}
