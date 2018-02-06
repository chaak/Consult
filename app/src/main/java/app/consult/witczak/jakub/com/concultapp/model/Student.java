package app.consult.witczak.jakub.com.concultapp.model;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.io.Serializable;
import java.util.List;

import app.consult.witczak.jakub.com.concultapp.utils.StudentKey;

/**
 * Created by JakubWitczak on 14.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
@ParseClassName("Student")
public class Student extends ParseObject implements Serializable {

    public Student() {
    }


    public String getFirstName() {
        return getString(StudentKey.FIRST_NAME);
    }

    public void setFirstName(String firstName) {
        put(StudentKey.FIRST_NAME, firstName);
    }

    public String getLastName() {
        return getString(StudentKey.LAST_NAME);
    }

    public void setLastName(String lastName) {
        put(StudentKey.LAST_NAME, lastName);
    }

    public String getUsername() {
        return getString(StudentKey.USERNAME);
    }

    public void setUserName(String username) {
        put(StudentKey.USERNAME, username);
    }

    public String getEmail() {
        return getString(StudentKey.EMAIL);
    }

    public void setEmail(String email) {
        put(StudentKey.EMAIL, email);
    }

    public String getPhoneNumber() {
        return getString(StudentKey.PHONE_NUMBER);
    }

    public void setPhoneNumber(String phoneNumber) {
        put(StudentKey.PHONE_NUMBER, phoneNumber);
    }

    public String getBirthday() {
        return getString(StudentKey.BIRTHDAY);
    }

    public void setBirthday(String birthday) {
        put(StudentKey.BIRTHDAY, birthday);
    }

    public ParseFile getProfileImage() {
        return getParseFile(StudentKey.PROFILE_PHOTO);
    }

    public void setProfileImage(ParseFile profileImageFile) {
        put(StudentKey.PROFILE_PHOTO, profileImageFile);
    }

    public List<Task> getTasks() {
        return getList(StudentKey.TASK_LIST);
    }

    public void setTasks(List<Task> tasks) {
        put(StudentKey.TASK_LIST, tasks);
    }
}
