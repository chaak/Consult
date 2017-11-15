package app.consult.witczak.jakub.com.concultapp.model;

import com.parse.ParseClassName;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import app.consult.witczak.jakub.com.concultapp.utils.UserKey;

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
        return getBoolean(UserKey.IS_STUDENT);
    }

    public void setIsStudent(boolean isStudent) {
        put(UserKey.IS_STUDENT, isStudent);
    }

    public ParseRelation<Student> getStudents() {
        return getRelation(UserKey.STUDENT_LIST);
    }

    public void setStudents(ParseRelation<Student> students) {
        put(UserKey.STUDENT_LIST, students);
    }

    public ParseRelation<Tutor> getTutors() {
        return getRelation(UserKey.TUTOR_LIST);
    }

    public void setTutors(ParseRelation<Tutor> tutors) {
        put(UserKey.TUTOR_LIST, tutors);
    }
}
