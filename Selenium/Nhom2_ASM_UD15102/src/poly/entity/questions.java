package poly.entity;

public class questions {
	private String title;
	private String category;
	private String tag;
	private String content;
	private String description;

	public questions(String title, String category, String tag, String content, String description) {
		super();
		this.title = title;
		this.category = category;
		this.tag = tag;
		this.content = content;
		this.description = description;
	}

	public questions() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
