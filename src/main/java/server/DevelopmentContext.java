package server;

import application.story.service.StoryAssembler;
import application.user.service.UserAssembler;
import domain.user.UserRepository;

public class DevelopmentContext extends Context {
	@Override
	public void initializeResource() {

		UserAssembler userAssembler = new UserAssembler();

		StoryAssembler storyAssembler = new StoryAssembler();


	}

	@Override
	public void registerServices() {

	}
}
