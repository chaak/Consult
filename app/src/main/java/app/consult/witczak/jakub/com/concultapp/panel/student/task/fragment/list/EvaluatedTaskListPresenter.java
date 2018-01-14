package app.consult.witczak.jakub.com.concultapp.panel.student.task.fragment.list;

import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import app.consult.witczak.jakub.com.concultapp.model.Task;

/**
 * Created by JakubWitczak on 19.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class EvaluatedTaskListPresenter implements EvaluatedTaskListContract.Presenter {

    private EvaluatedTaskListContract.View view;

    EvaluatedTaskListPresenter(EvaluatedTaskListContract.View view) {
        this.view = view;
    }

    @Override
    public void loadTasks() {
        ParseRelation<Task> relation = ParseUser.getCurrentUser().getRelation("tasks");
        ParseQuery<Task> query = relation.getQuery();
        query.findInBackground((objects, e) -> view.refreshView(objects));
    }
}
