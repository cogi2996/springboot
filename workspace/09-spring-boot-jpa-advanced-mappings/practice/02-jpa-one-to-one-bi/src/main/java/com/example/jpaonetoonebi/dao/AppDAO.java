package com.example.jpaonetoonebi.dao;

import com.example.jpaonetoonebi.enitty.Instructor;
import com.example.jpaonetoonebi.enitty.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);

}
