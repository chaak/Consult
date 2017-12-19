package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.my.list;

import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import app.consult.witczak.jakub.com.concultapp.model.Tutor;

/**
 * Created by JakubWitczak on 17.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class MyTutorsListPresenter implements MyTutorsListContract.Presenter {

    private MyTutorsListContract.View view;

    public MyTutorsListPresenter(MyTutorsListContract.View view) {
        this.view = view;
    }

    @Override
    public void loadMyTutors() {
        ParseRelation<Tutor> relation = ParseUser.getCurrentUser().getRelation("tutor_list");
        ParseQuery<Tutor> query = relation.getQuery();
        query.findInBackground((objects, e) -> view.refreshView(objects));
    }
}
