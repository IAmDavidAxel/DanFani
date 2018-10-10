package api.user;

import api.user.dto.ClientDto;
import application.user.service.UserService;

import javax.ws.rs.core.Response;

public class UserJsonResource {
	private UserService userService;

	public UserJsonResource(UserService userService) {

		this.userService = userService;
	}

	public Response create(ClientDto clientDto) {

		userService.create(clientDto);
		return null;
	}
}
