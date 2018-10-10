package application.story.service;

import api.story.StoryDto;
import domain.story.Story;
import domain.story.StoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StoryServiceTest {

	private StoryService storyService;

	@Mock
	private StoryAssembler storyAssembler;
	@Mock
	private StoryRepository storyRepository;
	private StoryDto storyDto;
	private Story story;

	@BeforeEach
	public void setUp(){
		storyDto = new StoryDto();
		storyService = new StoryService(storyAssembler,storyRepository);
	}

	@Test
	public void whenCreatingANewStory_thenDelegateConversionToTheAssembler()throws Exception{
		storyService.create(storyDto);

		verify(storyAssembler).assemble(storyDto);
	}

	@Test
	public void whenCreatingANewStory_thenDelegateSavingToTheRepo()throws Exception{
		willReturn(story).given(storyAssembler).assemble(storyDto);

		storyService.create(storyDto);

		verify(storyRepository).save(story);
	}

}