package com.collegecourses.dao;

import com.collegecourses.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
}
