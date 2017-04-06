package com.collegecourses;

import com.collegecourses.dao.CourseDao;
import com.collegecourses.dao.MemberDao;
import com.collegecourses.domain.Course;
import com.collegecourses.domain.Gender;
import com.collegecourses.domain.Member;
import com.collegecourses.domain.MemberType;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollegeCoursesApplicationTests {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	MemberDao memberDao;

	@Autowired
	CourseDao courseDao;


	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		memberDao.deleteAll();
	}

	@Test
	public void contextLoads() { }

	@Test
	public void getStudent() throws Exception {
		Member student = new Member();
		student.setFirstName("Matt");
		student.setLastName("Damon");
		student.setGender(Gender.MALE);
		student.setMemberType(MemberType.STUDENT);
		student.setAge(22);

		Integer id = memberDao.save(student).getId().intValue();

		this.mockMvc.perform(MockMvcRequestBuilders.get("/student/" + id)
				.contentType(contentType))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(id)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("Matt")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("Damon")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.age", Matchers.is(22)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.gender", Matchers.is("MALE")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.memberType", Matchers.is("STUDENT")));
	}

	@Test
	public void createStudent() throws Exception {
		String json = "{\"firstName\":\"Brad\",\"lastName\":\"Pitt\",\"age\":21,\"gender\":\"MALE\",\"memberType\":\"STUDENT\"}";

		this.mockMvc.perform(MockMvcRequestBuilders.post("/student/")
			.contentType(contentType)
			.content(json))
			.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void updateStudent() throws Exception {
		Member student = new Member();
		student.setFirstName("Scarlett");
		student.setLastName("Johansson");
		student.setGender(Gender.FEMALE);
		student.setMemberType(MemberType.STUDENT);
		student.setAge(18);

		Integer id = memberDao.save(student).getId().intValue();

		String json = "{\"id\":" + id + ",\"firstName\":\"Angelina\",\"lastName\":\"Johansson\",\"age\":18,\"gender\":\"FEMALE\",\"memberType\":\"STUDENT\"}";

		this.mockMvc.perform(MockMvcRequestBuilders.put("/student/")
				.contentType(contentType)
				.content(json))
				.andExpect(MockMvcResultMatchers.status().isNoContent());

		this.mockMvc.perform(MockMvcRequestBuilders.get("/student/" + id)
				.contentType(contentType))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(id)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("Angelina")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("Johansson")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.age", Matchers.is(18)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.gender", Matchers.is("FEMALE")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.memberType", Matchers.is("STUDENT")));
	}

	@Test
	public void deleteStudent() throws Exception {
		Member student = new Member();
		student.setFirstName("Will");
		student.setLastName("Smith");
		student.setGender(Gender.MALE);
		student.setMemberType(MemberType.STUDENT);
		student.setAge(19);

		Integer id = memberDao.save(student).getId().intValue();

		this.mockMvc.perform(MockMvcRequestBuilders.delete("/student/" + id)
				.contentType(contentType))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

	@Test
	public void getInstructor() throws Exception {
		Member instructor = new Member();
		instructor.setFirstName("Tom");
		instructor.setLastName("Cruise");
		instructor.setGender(Gender.MALE);
		instructor.setMemberType(MemberType.INSTRUCTOR);
		instructor.setAge(32);

		Integer id = memberDao.save(instructor).getId().intValue();

		this.mockMvc.perform(MockMvcRequestBuilders.get("/instructor/" + id)
				.contentType(contentType))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(id)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("Tom")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("Cruise")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.age", Matchers.is(32)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.gender", Matchers.is("MALE")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.memberType", Matchers.is("INSTRUCTOR")));
	}

	@Test
	public void createInstructor() throws Exception {
		String json = "{\"firstName\":\"Tom\",\"lastName\":\"Hanks\",\"age\":41,\"gender\":\"MALE\",\"memberType\":\"INSTRUCTOR\"}";

		this.mockMvc.perform(MockMvcRequestBuilders.post("/instructor/")
				.contentType(contentType)
				.content(json))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void updateInstructor() throws Exception {
		Member instructor = new Member();
		instructor.setFirstName("Carrie");
		instructor.setLastName("Fisher");
		instructor.setGender(Gender.FEMALE);
		instructor.setMemberType(MemberType.INSTRUCTOR);
		instructor.setAge(38);

		Integer id = memberDao.save(instructor).getId().intValue();

		String json = "{\"id\":" + id + ",\"firstName\":\"Kate\",\"lastName\":\"Upton\",\"age\":38,\"gender\":\"FEMALE\",\"memberType\":\"INSTRUCTOR\"}";

		this.mockMvc.perform(MockMvcRequestBuilders.put("/instructor/")
				.contentType(contentType)
				.content(json))
				.andExpect(MockMvcResultMatchers.status().isNoContent());

		this.mockMvc.perform(MockMvcRequestBuilders.get("/instructor/" + id)
				.contentType(contentType))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(id)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("Kate")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("Upton")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.age", Matchers.is(38)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.gender", Matchers.is("FEMALE")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.memberType", Matchers.is("INSTRUCTOR")));
	}

	@Test
	public void deleteInstructor() throws Exception {
		Member instructor = new Member();
		instructor.setFirstName("Jennifer");
		instructor.setLastName("Aniston");
		instructor.setGender(Gender.FEMALE);
		instructor.setMemberType(MemberType.INSTRUCTOR);
		instructor.setAge(49);

		Integer id = memberDao.save(instructor).getId().intValue();

		this.mockMvc.perform(MockMvcRequestBuilders.delete("/instructor/" + id)
				.contentType(contentType))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

	@Test
	public void getCourse() throws Exception {
		Course course = new Course();
		course.setTitle("History101");
		course.setDescription("A brief look at history");

		Integer id = courseDao.save(course).getId().intValue();

		this.mockMvc.perform(MockMvcRequestBuilders.get("/course/" + id)
				.contentType(contentType))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(id)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("History101")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.description", Matchers.is("A brief look at history")));
	}

	@Test
	public void createCourse() throws Exception {
		String json = "{\"title\": \"History102\",\"description\": \"History in a nutshell\"}";

		this.mockMvc.perform(MockMvcRequestBuilders.post("/course/")
				.contentType(contentType)
				.content(json))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void updateCourse() throws Exception {
		Course course = new Course();
		course.setTitle("Math101");
		course.setDescription("Math explained");

		Integer id = courseDao.save(course).getId().intValue();

		String json = "{\"id\": " + id + ",\"title\": \"Math103\",\"description\": \"Math explained again\"}";

		this.mockMvc.perform(MockMvcRequestBuilders.put("/course/")
				.contentType(contentType)
				.content(json))
				.andExpect(MockMvcResultMatchers.status().isNoContent());

		this.mockMvc.perform(MockMvcRequestBuilders.get("/course/" + id)
				.contentType(contentType))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(id)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Math103")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.description", Matchers.is("Math explained again")));
	}

	@Test
	public void deleteCourse() throws Exception {
		Course course = new Course();
		course.setTitle("Physics102");
		course.setDescription("Introduction to Physics");

		Integer id = courseDao.save(course).getId().intValue();

		this.mockMvc.perform(MockMvcRequestBuilders.delete("/course/" + id)
				.contentType(contentType))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}

}
