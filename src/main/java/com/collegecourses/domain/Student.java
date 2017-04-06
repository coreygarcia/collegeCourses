package com.collegecourses.domain;

import javax.persistence.Entity;

//@Entity
public class Student {
    /**
     * I originally wanted to have 2 separate domain objects to represent a Student and an Instructor
     * I instead created a Member entity that will hold both Students and Instructors
     * A MemberType lives on the Member entity to distinguish the member as either a Student or an Instructor
     * This will allow the creation of new member types (ie. faculty or other staff)
     * This also allows for easier sorting per requirement #5
     */
}
