package app.consult.witczak.jakub.com.concultapp.panel.tutor.adapter;

import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import app.consult.witczak.jakub.com.concultapp.model.Student;

/**
 * Created by JakubWitczak on 14.01.2018.
 * Copyright (C) Binar::Apps, 2017
 * All rights reserved.
 */
public class MyStudentsPresenter implements MyStudentsContract.Presenter {

    private MyStudentsContract.View view;

    public MyStudentsPresenter(MyStudentsContract.View view) {
        this.view = view;
    }

    @Override
    public void loadMyTutors() {
        ParseRelation<Student> relation = ParseUser.getCurrentUser().getRelation("student_list");
        ParseQuery<Student> query = relation.getQuery();
        query.findInBackground((objects, e) -> view.refreshView(objects));
    }
}
