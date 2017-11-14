package app.consult.witczak.jakub.com.concultapp.model;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.util.Date;
import java.util.List;

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
        return getString("first_name");
    }

    public void setFirstName(String firstName) {
        put("first_name", firstName);
    }

    public String getLastName() {
        return getString("last_name");
    }

    public void setLastName(String lastName) {
        put("last_name", lastName);
    }

    public String getEmail() {
        return getString("email");
    }

    public void setEmail(String email) {
        put("email", email);
    }

    public String getPhoneNumber() {
        return getString("phone_number");
    }

    public void setPhoneNumber(String phoneNumber) {
        put("phone_number", phoneNumber);
    }

    public Date getBirthday() {
        return getDate("birthday");
    }

    public void setBirthday(String birthday) {
        put("birthday", birthday);
    }

    public String getDescription() {
        return getString("description");
    }

    public void setDescription(String description) {
        put("description", description);
    }

    public ParseFile getProfileImage() {
        return getParseFile("profile_photo");
    }

    public void setProfileImage(ParseFile profileImage) {
        put("profile_photo", profileImage);
    }

    public String getCategory() {
        return getString("category");
    }

    public void setCategory(String category) {
        put("category", category);
    }

    public List<Task> getTasks() {
        return getList("taskList");
    }

    public void setTasks(List<Task> tasks) {
        put("taskList", tasks);
    }

    public List<Student> getStudents() {
        return getList("student_list");
    }

    public void setStudents(List<Student> students) {
        put("student_list", students);
    }
}
