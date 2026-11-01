package com.example.crud;

import com.example.crud.dto.CreateUserRequest;
import com.example.crud.model.User;
import com.example.crud.service.UserService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CrudApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private Validator validator;

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

	@Test
	void createUserRequest_shouldFailValidation_whenPayloadIsInvalid() {
		CreateUserRequest request = new CreateUserRequest();
		request.setName("");
		request.setEmail("invalid");

		Set<ConstraintViolation<CreateUserRequest>> violations = validator.validate(request);
		assertFalse(violations.isEmpty());
	}

	@Test
	void createUserRequest_shouldPassValidation_whenPayloadIsValid() {
		CreateUserRequest request = new CreateUserRequest();
		request.setName("Alice");
		request.setEmail("alice@example.com");

		Set<ConstraintViolation<CreateUserRequest>> violations = validator.validate(request);
		assertTrue(violations.isEmpty());
	}

}
