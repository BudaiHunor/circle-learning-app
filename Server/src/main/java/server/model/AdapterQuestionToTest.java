package server.model;

import java.util.ArrayList;
import java.util.List;

public class AdapterQuestionToTest implements CircleTestIF {
	private Question question;

	// getters
	public Question getQuestion() {
		return this.question;
	}

	@Override
	public List<Question> getQuestions() {
		List<Question> questions = new ArrayList<Question>();
		questions.add(this.question);
		return questions;
	}

	@Override
	public Question getQuestion(int n) {
		if (n == 0) {
			return this.getQuestion();
		} else {
			return null;
		}
	}

	// setters
	void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public void setQuestions(List<Question> questions) {
		this.question = questions.get(0);
	}

	@Override
	public void setQuestion(int n, Question question) {
		if (n == 0) {
			this.setQuestion(question);
		}
	}

	// newInstance methods
	public static AdapterQuestionToTest newInstance(Question question) {
		return new AdapterQuestionToTest(question);
	}

	// constructors
	private AdapterQuestionToTest(Question question) {
		this.setQuestion(question);
	}
}
