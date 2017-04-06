package com.collegecourses.service;

import com.collegecourses.domain.Course;

import java.util.List;

public interface ICourseService {

    /**
     * Saves Course entity
     * @param course
     * @return
     */
    Course save(Course course);

    /**
     * Returns Course entity by id
     * @param id
     * @return
     */
    Course findOne(Long id);

    /**
     * Returns a List of all Courses
     * @return
     */
    List<Course> findAll();


    /**
     * Deletes the Course entity by id
     * @param id
     */
    void delete(Long id);
}
