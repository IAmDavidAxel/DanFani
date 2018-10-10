package domain.story;

public class Story {

	private String title;
	private String description;
	private String content;

	public Story(String title, String description, String content) {
		this.title = title;
		this.description = description;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getContent() {
		return content;
	}

}
