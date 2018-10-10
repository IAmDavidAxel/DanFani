package application.user.service;

import api.user.dto.ClientDto;
import domain.user.UserProfile;
import domain.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserProfileServiceTest {

	private UserService userService;

	@Mock
	private UserRepository userRepository;
	@Mock
	private UserAssembler userAssembler;
	private ClientDto clientDto;
	private UserProfile userProfile;

	@BeforeEach
	public void setUp(){
		userService = new UserService(userAssembler,userRepository);
	}

	@Test
	public void whenCreatingANewUser_thenDelegateTransformationToTheAssembler()throws Exception{
		userService.create(clientDto);

		verify(userAssembler).assemble(clientDto);
	}

	@Test
	public void whenCreatingANewUser_thenDelegateSavingToTheRepo()throws Exception{
		willReturn(userProfile).given(userAssembler).assemble(clientDto);

		userService.create(clientDto);

		verify(userRepository).save(userProfile);
	}

}