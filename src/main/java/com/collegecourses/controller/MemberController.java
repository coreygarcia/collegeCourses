package com.collegecourses.controller;

import com.collegecourses.domain.Member;
import com.collegecourses.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    IMemberService memberService;

    /**
     * Lists all Instructor and Student entities, for example purposes, to demonstrate sorting
     * ie. GET http://localhost:8080/member/
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Member>> getAllMembersSorted(){
        return new ResponseEntity<>(memberService.findAllSortedBy(), HttpStatus.OK);
    }
}
