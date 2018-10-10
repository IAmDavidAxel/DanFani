package application.story.service;

import api.story.StoryDto;
import domain.story.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StoryAssemblerTest {

	private static final String TITLE = "origin";
	private static final String DESCRIPTION ="popo";
	private static final String CONTENT ="kok";

	private StoryAssembler storyAssembler;
	private StoryDto storyDto;
	private Story story;

	private void setUpDto(){
		storyDto = new StoryDto();

		storyDto.setTitle(TITLE);
		storyDto.setContent(CONTENT);
		storyDto.setDescription(DESCRIPTION);
	}

	@BeforeEach
	public void setUp(){
		setUpDto();
		storyAssembler = new StoryAssembler();
		story = new Story(TITLE,DESCRIPTION,CONTENT);
	}

	@Test
	public void whenAssembling_thenAllTheAttributesAreEquals()throws Exception{

		Story storyAssembled = storyAssembler.assemble(storyDto);

		assertEquals(storyAssembled.getTitle(),storyDto.getTitle());
		assertEquals(storyAssembled.getDescription(),storyDto.getDescription());
		assertEquals(storyAssembled.getContent(),storyDto.getContent());
	}

	@Test
	public void whenAssemblyingAStoryFromDomain_thenReturnADTOWithEqualsValues()throws Exception{
		StoryDto storyDtoAssembled = storyAssembler.assemble(story);

		assertEquals(storyDtoAssembled.getContent(),story.getContent());
		assertEquals(storyDtoAssembled.getDescription(),story.getDescription());
		assertEquals(storyDtoAssembled.getTitle(),story.getTitle());
	}

}