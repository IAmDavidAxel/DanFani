package application.story.service;

import api.story.StoryDto;
import domain.story.Story;
import domain.story.StoryRepository;

public class StoryService {
	private final StoryAssembler storyAssembler;
	private final StoryRepository storyRepository;

	public StoryService(StoryAssembler storyAssembler, StoryRepository storyRepository) {

		this.storyAssembler = storyAssembler;
		this.storyRepository = storyRepository;
	}

	public void create(StoryDto storyDto) {

		Story story = storyAssembler.assemble(storyDto);

		storyRepository.save(story);
	}
}
