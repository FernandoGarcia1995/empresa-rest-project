package com.company.project.company;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.project.interfaces.UserService;
import com.company.project.model.Rol;
import com.company.project.model.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void registrationTest() {
		User userSave = new User();
		
		userSave.setUsername("test1");
		userSave.setPassword(userService.encondePassword("1234"));
		userSave.setEmail("test@gmail.com");
		userSave.setRole(Rol.ROLE_EMPLOYEE);

		User userExist = userService.guardarUser(userSave);
				
		assertNotNull(userExist);	
	}

}
