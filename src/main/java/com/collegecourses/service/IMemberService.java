package com.collegecourses.service;

import com.collegecourses.domain.Member;
import com.collegecourses.domain.MemberType;

import java.util.List;

public interface IMemberService {

    /**
     * Saves Member entity
     * @param member
     * @return
     */
    Member save(Member member);

    /**
     * Returns Member entity by id
     * @param id
     * @return
     */
    Member findOne(Long id);

    /**
     * Returns a collection of Members by memberType (ie. Student or Instructor)
     * @param memberType
     * @return
     */
    List<Member> findByMemberType(MemberType memberType);


    /**
     * Deletes the Member entity by id
     * @param id
     */
    void delete(Long id);

    /**
     * Returns all Member entities sorted by:
     * A.) Alphabetically by last name and then first name
     * B.) If A is equal, instructors should come before students
     * C.) If A and B are equal, by age: persons with lower age will come before persons with higher age
     * D.) If A, B, and C are equal, by gender: persons that are female will come before persons that are male
     * @return
     */
    List<Member> findAllSortedBy();
}
