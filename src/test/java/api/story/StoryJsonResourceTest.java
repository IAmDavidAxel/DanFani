package api.story;

import application.story.service.StoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StoryJsonResourceTest {

	private StoryJsonResource storyJsonResource;

	@Mock
	private StoryService storyService;
	private StoryDto storyDto;

	@BeforeEach
	public void setUp(){
		storyJsonResource = new StoryJsonResource(storyService);
	}

	@Test
	public void whenCreatingANewStory_thenDelegateToTheService()throws Exception{

		storyJsonResource.create(storyDto);

		verify(storyService).create(storyDto);

	}
}
