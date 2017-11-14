package app.consult.witczak.jakub.com.concultapp.model;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

/**
 * Created by JakubWitczak on 14.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
@ParseClassName("Task")
public class Task extends ParseObject {

    public Task() {
    }

    public String getTitle() {
        return getString("title");
    }

    public void setTitle(String title) {
        put("title", title);
    }

    public String getCategory() {
        return getString("category");
    }

    public void setCategory(String category) {
        put("category", category);
    }

    public String getDescription() {
        return getString("description");
    }

    public void setDescription(String description) {
        put("description", description);
    }

    public Boolean getToDelete() {
        return getBoolean("to_delete");
    }

    public void setToDelete(Boolean toDelete) {
        put("to_delete", toDelete);
    }

    public ParseFile getTaskImage() {
        return getParseFile("image_path");
    }

    public void setTaskImage(ParseFile taskImage) {
        put("image_path", taskImage);
    }

    public Student getRecipientStudent() {
        return (Student) get("student");
    }

    public void setRecipientStudent(Student recipientStudent) {
        put("student", recipientStudent);
    }

    public Tutor getRecipientTutor() {
        return (Tutor) get("tutor");
    }

    public void setRecipientTutor(Tutor recipientTutor) {
        put("tutor", recipientTutor);
    }
}
