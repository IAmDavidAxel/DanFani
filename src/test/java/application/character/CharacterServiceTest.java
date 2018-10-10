package application.character;

import api.character.dto.CharacterDto;
import domain.character.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CharacterServiceTest {

	private CharacterService characterService;

	@Mock
	private CharacterRepository characterRepository;
	@Mock
	private CharacterAssembler characterAssembler;
	private CharacterDto characterDto;
	private Character character;

	@BeforeEach
	public void setUp(){
		characterService = new CharacterService(characterAssembler,characterRepository);
	}

	@Test
	public void whenCreatingANewCharacter_thenDelegateDessamblyToTheAssembler()throws Exception{
		characterService.create(characterDto);

		verify(characterAssembler).assemble(characterDto);
	}

	@Test
	public void whenCreaingANewCharacter_thenDeleagateSavingToTheRepository()throws Exception{
		willReturn(character).given(characterAssembler).assemble(characterDto);

		characterService.create(characterDto);

		verify(characterRepository).save(character);
	}

}