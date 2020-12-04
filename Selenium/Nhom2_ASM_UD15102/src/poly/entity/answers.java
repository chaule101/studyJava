package poly.entity;

public class answers {
	
	private String question;
	private String answers;
	
	public answers(String question, String answers) {
		super();
		this.question = question;
		this.answers = answers;
	}

	public answers() {
		super();
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}
	
	
	
}
