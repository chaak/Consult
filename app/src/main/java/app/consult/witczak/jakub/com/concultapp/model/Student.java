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
@ParseClassName("Student")
public class Student extends ParseObject {

    public Student() {
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

    public ParseFile getProfileImageFile() {
        return getParseFile("profile_image_path");
    }

    public void setProfileImageFile(ParseFile profileImageFile) {
        put("profile_image_path", profileImageFile);
    }

    public List<Task> getTasks() {
        return getList("task_list");
    }

    public void setTasks(List<Task> tasks) {
        put("task_list", tasks);
    }

    public List<Tutor> getTutors() {
        return getList("tutor_list");
    }

    public void setTutors(List<Tutor> tutors) {
        put("tutor_list", tutors);
    }
}
