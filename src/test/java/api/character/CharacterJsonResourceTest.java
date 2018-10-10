package api.character;

import api.character.dto.CharacterDto;
import application.character.CharacterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CharacterJsonResourceTest {

	private static final String A_NAME = "David";
	private CharacterJsonResource characterJsonResource;

	@Mock
	private CharacterService characterService;
	private CharacterDto characterDto;

	@BeforeEach
	public void setUp(){
		characterJsonResource = new CharacterJsonResource(characterService);
	}

	@Test
	public void whenCreatingANewCharacter_thenDelegateToTheService()throws Exception{
		characterJsonResource.create(characterDto);

		verify(characterService).create(characterDto);
	}

	@Test
	public void whenFindingACharacter_thenDelegateToTheService()throws Exception{
		characterJsonResource.findBy(A_NAME);

		verify(characterService).findBy(A_NAME);
	}

}
