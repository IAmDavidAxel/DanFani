package application.story.service;

import api.story.StoryDto;
import domain.story.Story;

public class StoryAssembler {
	public Story assemble(StoryDto storyDto) {

		String title = storyDto.getTitle();
		String description =storyDto.getDescription();
		String content = storyDto.getContent();

		return new Story(title,description,content);
	}

	public StoryDto assemble(Story story) {
		StoryDto storyDto = new StoryDto();

		storyDto.setDescription(story.getDescription());
		storyDto.setContent(story.getContent());
		storyDto.setTitle(story.getTitle());


		return storyDto;
	}
}
