package com.collegecourses.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "classroom")
public class Classroom {

    private Long id;
    private String roomNumber;
    private String buildingName;
    private Course course;
    private Member instructor;
    private Time startTime;
    private List<ClassroomStudent> classroomStudents;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "room_number")
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Column(name = "building_name")
    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @ManyToOne
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne
    @JoinColumn(name = "member_id")
    public Member getInstructor() {
        return instructor;
    }

    public void setInstructor(Member instructor) {
        this.instructor = instructor;
    }

    @Column(name = "start_time")
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @OneToMany
    public List<ClassroomStudent> getClassroomStudents() {
        return classroomStudents;
    }

    public void setClassroomStudents(List<ClassroomStudent> classroomStudents) {
        this.classroomStudents = classroomStudents;
    }
}
