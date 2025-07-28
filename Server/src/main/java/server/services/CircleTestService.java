package server.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import server.model.CircleTest;
import server.model.Question;

@RestController
public class CircleTestService {

	@GetMapping(value = "/request")
	public List<Question> request() {
		return CircleTest.newInstance().getQuestions();
	}
}
