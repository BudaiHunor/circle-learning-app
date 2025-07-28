package client.model;

import java.util.ArrayList;
import java.util.List;

import client.repository.QuestionFactory;

public class CircleTest {
	private static final int QUESTION_NR = 10;
	private static final int QUESTION_TOTAL = 50;

	private List<Question> questions;

	// getters
	public List<Question> getQuestions() {
		return this.questions;
	}

	public Question getQuestion(int n) {
		if (0 > n || n >= CircleTest.QUESTION_NR) {
			return null;
		}
		return this.getQuestions().get(n);
	}

	// setters
	void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	void setQuestion(int n, Question question) {
		if (0 > n || n >= CircleTest.QUESTION_NR) {
			return;
		}
		this.getQuestions().set(n, question);
	}

	// methods
	public String getQuestionNText(int n) {
		return this.getQuestion(n).getQuestion();
	}

	public String getQuestionNAnswer1(int n) {
		return this.getQuestion(n).getAnswer1();
	}

	public String getQuestionNAnswer2(int n) {
		return this.getQuestion(n).getAnswer2();
	}

	public String getQuestionNAnswer3(int n) {
		return this.getQuestion(n).getAnswer3();
	}

	public boolean isQuestionNCorrect1(int n) {
		return this.getQuestion(n).isCorrect1();
	}

	public boolean isQuestionNCorrect2(int n) {
		return this.getQuestion(n).isCorrect2();
	}

	public boolean isQuestionNCorrect3(int n) {
		return this.getQuestion(n).isCorrect3();
	}

	/**
	 * TODO TO REMOVE!
	 */
	private void generateRandomQuestions() {
		this.setQuestions(new ArrayList<Question>());
		for (int set = 0; set < CircleTest.QUESTION_TOTAL; set += 5) {
			int offset1 = (int) (Math.random() * 5) + 1;
			int index1 = set + offset1;

			int offset2 = (int) (Math.random() * 4) + 1;
			int index2 = set + offset2 + (offset1 <= offset2 ? 1 : 0);

			this.getQuestions().add(QuestionFactory.readQuestion(index1));
			this.getQuestions().add(QuestionFactory.readQuestion(index2));
		}
	}

	// newInstance methods
	/**
	 * TODO TO REMOVE!
	 */
	public static CircleTest newInstance() {
		CircleTest test = new CircleTest(new ArrayList<Question>());
		test.generateRandomQuestions();
		return test;
	}

	public static CircleTest newInstance(List<Question> questions) {
		return new CircleTest(questions);
	}

	// constructors
	private CircleTest(List<Question> questions) {
		this.setQuestions(questions);
	}
}
