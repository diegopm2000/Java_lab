package com.example.democonsole;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoconsoleApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(DemoconsoleApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(DemoconsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("HelloWorld SpringBoot Console!");
	}
}
