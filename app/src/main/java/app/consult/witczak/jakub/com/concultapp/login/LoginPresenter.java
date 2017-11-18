package app.consult.witczak.jakub.com.concultapp.login;

import com.parse.ParseObject;

import app.consult.witczak.jakub.com.concultapp.model.Student;
import app.consult.witczak.jakub.com.concultapp.model.Task;
import app.consult.witczak.jakub.com.concultapp.model.Tutor;
import app.consult.witczak.jakub.com.concultapp.model.User;

/**
 * Created by JakubWitczak on 12.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void registerSubclasses() {
        ParseObject.registerSubclass(User.class);
        ParseObject.registerSubclass(Student.class);
        ParseObject.registerSubclass(Tutor.class);
        ParseObject.registerSubclass(Task.class);
    }
}
