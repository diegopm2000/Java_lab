package com.example.demoweb;

import com.example.demoweb.model.User;
import com.example.demoweb.repo.IUserRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemowebApplicationTests {

	@Autowired
	private IUserRepo repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void createUserTest() {
		User us = new User();
		us.setId(3);
		us.setName("user");
		us.setPassword(encoder.encode("password"));
		User result = repo.save(us);

		assertTrue(result.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
