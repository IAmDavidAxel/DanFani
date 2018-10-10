package api.user;

import api.user.dto.ClientDto;
import application.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserProfileJsonResourceTest {

	private UserJsonResource userJsonResource;
	@Mock
	private UserService userService;
	private ClientDto clientDto;


	@BeforeEach
	public void setUp(){
		clientDto = new ClientDto();
		userJsonResource = new UserJsonResource(userService);
	}

	@Test
	public void whenCreatingANewUser_thenDelegateToTheUserService()throws Exception{
		userJsonResource.create(clientDto);

		verify(userService).create(clientDto);
	}
}
