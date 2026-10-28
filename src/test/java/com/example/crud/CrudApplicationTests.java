package com.example.crud;

import com.example.crud.model.User;
import com.example.crud.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class CrudApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}

	@Test
	void deleteUser_shouldRemoveExistingUser() {
		User user = new User();
		user.setName("Delete User");
		user.setEmail("delete@example.com");

		User saved = userService.createUser(user);
		assertDoesNotThrow(() -> userService.deleteUser(saved.getId()));
	}

}
