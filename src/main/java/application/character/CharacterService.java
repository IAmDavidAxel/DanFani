package application.character;

import api.character.dto.CharacterDto;
import domain.character.CharacterRepository;

public class CharacterService {
	private final CharacterAssembler characterAssembler;
	private final CharacterRepository characterRepository;

	public CharacterService(CharacterAssembler characterAssembler, CharacterRepository characterRepository) {

		this.characterAssembler = characterAssembler;
		this.characterRepository = characterRepository;
	}

	public void create(CharacterDto characterDto) {

		Character character = characterAssembler.assemble(characterDto);

		characterRepository.save(character);

	}

	public CharacterDto findBy(String name) {
		return null;
	}
}
