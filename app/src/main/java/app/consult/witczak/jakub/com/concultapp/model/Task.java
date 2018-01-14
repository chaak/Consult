package app.consult.witczak.jakub.com.concultapp.model;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.io.Serializable;

import app.consult.witczak.jakub.com.concultapp.utils.TaskKey;

/**
 * Created by JakubWitczak on 14.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
@ParseClassName("Task")
public class Task extends ParseObject implements Serializable {

    public Task() {
    }

    public String getTitle() {
        return getString(TaskKey.TITLE);
    }

    public void setTitle(String title) {
        put(TaskKey.TITLE, title);
    }

    public String getCategory() {
        return getString(TaskKey.CATEGORY);
    }

    public void setCategory(String category) {
        put(TaskKey.CATEGORY, category);
    }

    public String getDescription() {
        return getString(TaskKey.DESCRIPTION);
    }

    public void setDescription(String description) {
        put(TaskKey.DESCRIPTION, description);
    }

    public Boolean getToDelete() {
        return getBoolean(TaskKey.TO_DELETE);
    }

    public void setToDelete(Boolean toDelete) {
        put(TaskKey.TO_DELETE, toDelete);
    }

    public ParseFile getTaskImage() {
        return getParseFile(TaskKey.IMAGE_PATH);
    }

    public void setTaskImage(ParseFile taskImage) {
        put(TaskKey.IMAGE_PATH, taskImage);
    }

    public Student getRecipientStudent() {
        return (Student) get(TaskKey.STUDENT);
    }

    public void setRecipientStudent(Student recipientStudent) {
        put(TaskKey.STUDENT, recipientStudent);
    }

    public Tutor getRecipientTutor() {
        return (Tutor) get(TaskKey.TUTOR);
    }

    public void setRecipientTutor(Tutor recipientTutor) {
        put(TaskKey.TUTOR, recipientTutor);
    }
}
