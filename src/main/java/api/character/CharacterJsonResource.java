package api.character;

import api.character.dto.CharacterDto;
import application.character.CharacterService;

import javax.ws.rs.core.Response;

public class CharacterJsonResource {

	private CharacterService characterService;

	public CharacterJsonResource(CharacterService characterService) {

		this.characterService = characterService;
	}

	public Response create(CharacterDto characterDto) {

		characterService.create(characterDto);
		return null;
	}

	public CharacterDto findBy(String aName) {

		characterService.findBy(aName);

		return null;
	}
}
