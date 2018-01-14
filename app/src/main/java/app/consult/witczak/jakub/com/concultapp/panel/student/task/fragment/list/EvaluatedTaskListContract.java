package app.consult.witczak.jakub.com.concultapp.panel.student.task.fragment.list;

import java.util.List;

import app.consult.witczak.jakub.com.concultapp.model.Task;

/**
 * Created by JakubWitczak on 19.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public interface EvaluatedTaskListContract {

    interface View {
        void refreshView(List<Task> tasks);
    }

    interface Presenter {
        void loadTasks();
    }
}
