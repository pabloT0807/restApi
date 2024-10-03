package com.proyecto.crud;

import com.proyecto.crud.dao.UserDao;
import com.proyecto.crud.dao.UserDaoImpl;
import com.proyecto.crud.entity.Address;
import com.proyecto.crud.entity.Company;
import com.proyecto.crud.entity.Geo;
import com.proyecto.crud.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CrudApplicationTests {

	@Mock
	private UserDao userDao;

	@InjectMocks
	private UserDaoImpl userDaoImpl;

	@MockBean
	private RestTemplate restTemplate;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}


	@Test
	void contextLoads() {

		Address address = new Address("Kulas Light", "Apt. 556", "Gwenborough", "92998-3874", new Geo("-37.3159", "81.1496"));
		Company company = new Company("Romaguera-Crona", "Multi-layered client-server neural-net", "harness real-time e-markets");

		User user1 = new User(1L, "Leanne Graham", "Sincere@april.biz", address, "1-770-736-8031 x56442", "hildegard.org", company);
		User user2 = new User(2L, "Ervin Howell", "Shanna@melissa.tv", address, "010-692-6593 x09125", "anastasia.net", company);

		List<User> userList = Arrays.asList(user1,user2);
		when(restTemplate.exchange(
				"https://jsonplaceholder.typicode.com/users",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<User>>() {}
		)).thenReturn(ResponseEntity.ok(userList));

		List<User> users = userDaoImpl.getAllUsers();
		assertEquals(2, users.size());
		assertEquals("Leanne Graham", users.get(0).getName());
		assertEquals("Ervin Howell", users.get(1).getName());

	}

}
