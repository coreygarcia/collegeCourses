package com.collegecourses.controller;

import com.collegecourses.domain.Member;
import com.collegecourses.domain.MemberType;
import com.collegecourses.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    IMemberService memberService;

    /**
     * Lists all Student entities
     * ie. GET http://localhost:8080/student/
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Member>> getAllStudents(){
        return new ResponseEntity<>(memberService.findByMemberType(MemberType.STUDENT), HttpStatus.OK);
    }

    /**
     * Gets a Student entity by id
     * ie. GET http://localhost:8080/student/1
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Member> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(memberService.findOne(id), HttpStatus.OK);
    }

    /**
     * Adds a new Student entity
     * ie. POST http://localhost:8080/student/
     * @param student
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addStudent(@RequestBody Member student) {
        return new ResponseEntity<>(memberService.save(student), HttpStatus.CREATED);
    }

    /**
     * Updates a Student entity
     * ie. PUT http://localhost:8080/student/
     * @param student
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateStudent(@RequestBody Member student) {
        return new ResponseEntity<>(memberService.save(student), HttpStatus.NO_CONTENT);
    }

    /**
     * Deletes a Student entity
     * * ie. DELETE http://localhost:8080/student/1
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
