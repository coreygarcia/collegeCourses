package com.collegecourses.service.impl;

import com.collegecourses.dao.CourseDao;
import com.collegecourses.domain.Course;
import com.collegecourses.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {

    @Autowired
    CourseDao courseDao;

    @Override
    public Course save(Course course) {
        return courseDao.save(course);
    }

    @Override
    public Course findOne(Long id) {
        return courseDao.findOne(id);
    }

    @Override
    public List<Course> findAll() {
        return (List) courseDao.findAll();
    }

    @Override
    public void delete(Long id) {
        courseDao.delete(id);
    }

}
