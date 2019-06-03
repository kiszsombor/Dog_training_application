package hu.elte.DogTrainingApplication;

import hu.elte.DogTrainingApplication.api.DogService;
import hu.elte.DogTrainingApplication.entities.Dog;
import hu.elte.DogTrainingApplication.entities.SeasonTicket;
import hu.elte.DogTrainingApplication.repository.DogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DogTrainingApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	private Dog dog;

	@Autowired
	private DogService dogService;

	@MockBean
	private DogRepository dogRepository;


	Integer id=1;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		dog = new Dog();
		dog.setId(id);
	}

	@Test
	public void findDogById() {

		System.out.println(dog);
		Optional<Dog> dog2=dogService.findById(id);
		System.out.println("Id alaján ugyanaz a kutya: ---   " + dog2);

		//assertEquals(dog,dog2);

	}


	//@Test
	public void testDog1() throws Exception {

		mockMvc.perform(get("/dog/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("Buksi"))
//				.andExpect(jsonPath("$.birthDate").value("2019-04-27T22:22:03.000+0000"))
				.andExpect(jsonPath("$.breed").value("breed_Buksi"))
				.andExpect(jsonPath("$.weight").value(5));
	}

	//@Test
	public void testDog2() throws Exception {

		mockMvc.perform(get("/dog/2")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("Morci"))
//				.andExpect(jsonPath("$.birthDate").value("2019-04-27T22:22:03.000+0000"))
				.andExpect(jsonPath("$.breed").value("breed_Morci"))
				.andExpect(jsonPath("$.weight").value(5));
	}

	//@Test
	public void testDogs() throws Exception {

		mockMvc.perform(get("/dog")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$[0].name").value("Buksi"))
				.andExpect(jsonPath("$[0].birthDate").value("2019-04-27T22:22:03.000+0000"))
				.andExpect(jsonPath("$[0].breed").value("breed_Buksi"))
				.andExpect(jsonPath("$[0].weight").value(5));

		mockMvc.perform(get("/dog")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$[1].name").value("Morci"))
				.andExpect(jsonPath("$[1].birthDate").value("2019-04-27T22:22:03.000+0000"))
				.andExpect(jsonPath("$[1].breed").value("breed_Morci"))
				.andExpect(jsonPath("$[1].weight").value(5));
	}

	@Test
	public void testTrainer1() throws Exception {

		mockMvc.perform(get("/trainer/1")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("Nagy Emma"))
				.andExpect(jsonPath("$.email").value("emma1@gmail.com"))
				// .andExpect(jsonPath("$.address").value("emma_address"))
				.andExpect(jsonPath("$.phoneNumber").value(305552145))
				// .andExpect(jsonPath("$.birthDate").value("1995-03-05 00:00:00"))
				.andExpect(jsonPath("$.birthPlace").value("Budapest"));
	}

	@Test
	public void testTrainer2() throws Exception {

		mockMvc.perform(get("/trainer/2")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.name").value("Kis Károly"))
				.andExpect(jsonPath("$.email").value("karcsi25@gmail.com"))
				// .andExpect(jsonPath("$.address").value("karesz_address"))
				.andExpect(jsonPath("$.phoneNumber").value(305552145))
				// .andExpect(jsonPath("$.birthDate").value("1990-04-16 00:00:00"))
				.andExpect(jsonPath("$.birthPlace").value("Budapest"));
	}

}
