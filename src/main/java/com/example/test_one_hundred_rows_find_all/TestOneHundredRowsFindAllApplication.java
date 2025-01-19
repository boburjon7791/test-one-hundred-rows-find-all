package com.example.test_one_hundred_rows_find_all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.Instant;

@SpringBootApplication
public class TestOneHundredRowsFindAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestOneHundredRowsFindAllApplication.class, args);

		RestTemplate restTemplate = new RestTemplate();

		Instant start = Instant.now();
		ResponseEntity<String> transactionsJson = restTemplate.getForEntity("http://localhost:8080/api/transaction", String.class);
		Instant end = Instant.now();

//		long withEntityGraph = Duration.between(start, end).toMillis();
//		System.out.println("withEntityGraph = " + withEntityGraph);       // 4473 millisekund, 4.47 sekund

//		long withoutEntityGraph = Duration.between(start, end).toMillis();
//		System.out.println("withoutEntityGraph = " + withoutEntityGraph); // 61207 millisekund, 61.2 sekund
	}

}
