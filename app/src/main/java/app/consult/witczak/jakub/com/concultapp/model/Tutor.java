package app.consult.witczak.jakub.com.concultapp.model;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.util.Date;
import java.util.List;

import app.consult.witczak.jakub.com.concultapp.utils.TutorKey;

/**
 * Created by JakubWitczak on 14.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
@ParseClassName("Tutor")
public class Tutor extends ParseObject {

    public Tutor() {
    }

    public String getFirstName() {
        return getString(TutorKey.FIRST_NAME);
    }

    public void setFirstName(String firstName) {
        put(TutorKey.FIRST_NAME, firstName);
    }

    public String getLastName() {
        return getString(TutorKey.LAST_NAME);
    }

    public void setLastName(String lastName) {
        put(TutorKey.FIRST_NAME, lastName);
    }

    public String getEmail() {
        return getString(TutorKey.EMAIL);
    }

    public void setEmail(String email) {
        put(TutorKey.EMAIL, email);
    }

    public String getPhoneNumber() {
        return getString(TutorKey.PHONE_NUMBER);
    }

    public void setPhoneNumber(String phoneNumber) {
        put(TutorKey.PHONE_NUMBER, phoneNumber);
    }

    public Date getBirthday() {
        return getDate(TutorKey.BIRTHDAY);
    }

    public void setBirthday(String birthday) {
        put(TutorKey.BIRTHDAY, birthday);
    }

    public String getDescription() {
        return getString(TutorKey.DESCRIPTION);
    }

    public void setDescription(String description) {
        put(TutorKey.DESCRIPTION, description);
    }

    public ParseFile getProfileImage() {
        return getParseFile(TutorKey.PROFILE_PHOTO);
    }

    public void setProfileImage(ParseFile profileImage) {
        put(TutorKey.PROFILE_PHOTO, profileImage);
    }

    public String getCategory() {
        return getString(TutorKey.CATEGORY);
    }

    public void setCategory(String category) {
        put(TutorKey.CATEGORY, category);
    }

    public List<Task> getTasks() {
        return getList(TutorKey.TASK_LIST);
    }

    public void setTasks(List<Task> tasks) {
        put(TutorKey.TASK_LIST, tasks);
    }

    public List<Student> getStudents() {
        return getList(TutorKey.STUDENT_LIST);
    }

    public void setStudents(List<Student> students) {
        put(TutorKey.STUDENT_LIST, students);
    }
}
