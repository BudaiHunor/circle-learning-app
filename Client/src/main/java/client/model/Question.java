package client.model;

public class Question {
	private int id;
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private boolean correct1;
	private boolean correct2;
	private boolean correct3;

	// getters
	public int getId() {
		return this.id;
	}

	public String getQuestion() {
		return this.question;
	}

	public String getAnswer1() {
		return this.answer1;
	}

	public String getAnswer2() {
		return this.answer2;
	}

	public String getAnswer3() {
		return this.answer3;
	}

	public boolean isCorrect1() {
		return this.correct1;
	}

	public boolean isCorrect2() {
		return this.correct2;
	}

	public boolean isCorrect3() {
		return this.correct3;
	}

	// setters
	public void setId(int id) {
		this.id = id;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setAnswer1(String answer) {
		this.answer1 = answer;
	}

	public void setAnswer2(String answer) {
		this.answer2 = answer;
	}

	public void setAnswer3(String answer) {
		this.answer3 = answer;
	}

	public void setCorrect1(boolean correct) {
		this.correct1 = correct;
	}

	public void setCorrect2(boolean correct) {
		this.correct2 = correct;
	}

	public void setCorrect3(boolean correct) {
		this.correct3 = correct;
	}

	// newInstance methods
	public static Question newInstance(int id, String question, String answer1, String answer2, String answer3,
			boolean correct1, boolean correct2, boolean correct3) {
		if (id < 0 || question == null || answer1 == null || answer2 == null || answer3 == null) {
			return null;
		}
		return new Question(id, question, answer1, answer2, answer3, correct1, correct2, correct3);
	}

	// constructors
	private Question(int id, String question, String answer1, String answer2, String answer3, boolean correct1,
			boolean correct2, boolean correct3) {
		this.setId(id);
		this.setQuestion(question);
		this.setAnswer1(answer1);
		this.setAnswer2(answer2);
		this.setAnswer3(answer3);
		this.setCorrect1(correct1);
		this.setCorrect2(correct2);
		this.setCorrect3(correct3);
	}

	public Question() {
		this.setId(0);
		this.setQuestion("");
		this.setAnswer1("");
		this.setAnswer2("");
		this.setAnswer3("");
		this.setCorrect1(false);
		this.setCorrect2(false);
		this.setCorrect3(false);
	}
}
