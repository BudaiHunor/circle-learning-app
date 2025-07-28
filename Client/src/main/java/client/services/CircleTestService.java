package client.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import client.model.CircleTest;
import client.model.Question;

public class CircleTestService {
	private final String SERVER_URL = "http://localhost:333";
	private final HttpClient client = HttpClient.newHttpClient();
	private final ObjectMapper objectMapper = new ObjectMapper();

	public CircleTest get() throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(SERVER_URL + "/request"))
				.header("Content-Type", "application/json").GET().build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		if (response.statusCode() == 200) { // success
			return CircleTest.newInstance(objectMapper.readValue(response.body(), new TypeReference<List<Question>>() {
			}));
		} else {
			return null; // fail
		}
	}
}
