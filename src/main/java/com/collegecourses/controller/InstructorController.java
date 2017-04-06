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
@RequestMapping(value = "/instructor")
public class InstructorController {

    @Autowired
    IMemberService memberService;

    /**
     * Lists all Instructor entities
     * ie. GET http://localhost:8080/instructor/
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Member>> getAllInstructors(){
        return new ResponseEntity<>(memberService.findByMemberType(MemberType.INSTRUCTOR), HttpStatus.OK);
    }

    /**
     * Gets an Instructor entity by id
     * ie. GET http://localhost:8080/instructor/1
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Member> getInstructor(@PathVariable Long id){
        return new ResponseEntity<>(memberService.findOne(id), HttpStatus.OK);
    }

    /**
     * Adds a new Instructor entity
     * ie. POST http://localhost:8080/instructor/
     * @param instructor
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addInstructor(@RequestBody Member instructor) {
        return new ResponseEntity<>(memberService.save(instructor), HttpStatus.CREATED);
    }

    /**
     * Updates an Instructor entity
     * ie. PUT http://localhost:8080/instructor/
     * @param instructor
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateInstructor(@RequestBody Member instructor) {
        return new ResponseEntity<>(memberService.save(instructor), HttpStatus.NO_CONTENT);
    }

    /**
     * Deletes an Instructor entity
     * ie. DELETE http://localhost:8080/instructor/1
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteInstructor(@PathVariable Long id){
        memberService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
