package com.example.calculator;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorAPIRESTTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void shouldReturnTheSumOfTwoNumbers() {

		Integer a = 4;
		Integer b = 5;
		Integer result = a + b;

		this.webTestClient
				.get()
				.uri("/api/calculator/add?a={a}&b={b}",a, b)
				.exchange()
				.expectStatus()
				.isOk()
				.expectBody(Integer.class)
				.isEqualTo(result);
	}
}
