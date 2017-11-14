package app.consult.witczak.jakub.com.concultapp.model;

import com.parse.ParseClassName;
import com.parse.ParseUser;

import java.util.List;

/**
 * Created by JakubWitczak on 14.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */

@ParseClassName("User")
public class User extends ParseUser {

    public User() {
    }

    public boolean getIsStudent() {
        return getBoolean("is_student");
    }

    public void setIsStudent(boolean isStudent) {
        put("is_student", isStudent);
    }

    public List<Student> getStudents() {
        return getList("student_list");
    }

    public void setStudents(List<Student> students) {
        put("student_list", students);
    }

    public List<Tutor> getTutors() {
        return getList("tutor_list");
    }

    public void setTutors(List<Tutor> tutors) {
        put("tutor_list", tutors);
    }
}
