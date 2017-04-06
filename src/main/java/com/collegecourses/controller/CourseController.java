package com.collegecourses.controller;

import com.collegecourses.domain.Course;
import com.collegecourses.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    ICourseService courseService;

    /**
     * Lists all Course entities
     * ie. GET http://localhost:8080/course/
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Course>> getAllCourses(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    /**
     * Gets a Course entity by id
     * ie. GET http://localhost:8080/course/1
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        return new ResponseEntity<>(courseService.findOne(id), HttpStatus.OK);
    }

    /**
     * Adds a new Course entity
     * ie. POST http://localhost:8080/course/
     * @param course
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.save(course), HttpStatus.CREATED);
    }

    /**
     * Updates a Course entity
     * ie. PUT http://localhost:8080/course/
     * @param course
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.save(course), HttpStatus.NO_CONTENT);
    }

    /**
     * Deletes a Course entity
     * ie. DELETE http://localhost:8080/course/1
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCourse(@PathVariable Long id){
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
