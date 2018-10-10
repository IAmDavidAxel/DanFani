package api.story;

import application.story.service.StoryService;

import javax.ws.rs.core.Response;

public class StoryJsonResource {

	private StoryService storyService;

	public StoryJsonResource(StoryService storyService) {

		this.storyService = storyService;
	}

	public Response create(StoryDto storyDto) {

		storyService.create(storyDto);
		return null;
	}
}
