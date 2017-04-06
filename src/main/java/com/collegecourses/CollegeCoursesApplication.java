package com.collegecourses;

import com.collegecourses.domain.Gender;
import com.collegecourses.domain.Member;
import com.collegecourses.domain.MemberType;
import com.collegecourses.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.collegecourses")
public class CollegeCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeCoursesApplication.class, args);
	}
}
