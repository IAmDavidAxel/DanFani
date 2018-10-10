package application.user.service;

import api.user.dto.ClientDto;
import domain.user.UserProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserProfileAssemblerTest {

	private static final String NAME = "jordan";
	private static final String LAST_NAME ="Michael";
	private static final String NICKNAME ="Goat";
	private static final int AGE = 18;

	private UserAssembler userAssembler;
	private ClientDto clientDto;
	private UserProfile userProfile;

	private void setUpDto(){
		clientDto = new ClientDto();

		clientDto.setLastName(LAST_NAME);
		clientDto.setName(NAME);
		clientDto.setNickname(NICKNAME);
		clientDto.setAge(AGE);

	}

	@BeforeEach
	public void setUp(){
		setUpDto();
		userProfile = new UserProfile(NAME,LAST_NAME,NICKNAME);
		userAssembler = new UserAssembler();
	}


	@Test
	public void whenAssembling_thenAllAttributesAreEquals()throws Exception{

		UserProfile userProfileAssembled = userAssembler.assemble(clientDto);

		assertEquals(clientDto.getName(), userProfileAssembled.getName());
		assertEquals(clientDto.getLastName(), userProfileAssembled.getLastName());
		assertEquals(clientDto.getNickname(), userProfileAssembled.getNickName());
		assertEquals(clientDto.getAge(),userProfileAssembled.getAge());

	}





}