package com.collegecourses.domain;

import javax.persistence.*;

@Entity
@Table(name = "classroom_student")
public class ClassroomStudent {

    private Long id;
    private Classroom classroom;
    private Member student;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @ManyToOne
    @JoinColumn(name = "member_id")
    public Member getStudent() {
        return student;
    }

    public void setStudent(Member student) {
        this.student = student;
    }

}
