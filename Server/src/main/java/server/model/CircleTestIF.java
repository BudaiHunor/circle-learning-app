package server.model;

import java.util.List;

public interface CircleTestIF {
	public List<Question> getQuestions();

	public Question getQuestion(int n);

	void setQuestions(List<Question> questions);

	void setQuestion(int n, Question question);
}
