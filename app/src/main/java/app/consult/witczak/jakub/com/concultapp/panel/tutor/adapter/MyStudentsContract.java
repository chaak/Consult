package app.consult.witczak.jakub.com.concultapp.panel.tutor.adapter;

import java.util.List;

import app.consult.witczak.jakub.com.concultapp.model.Student;

/**
 * Created by JakubWitczak on 14.01.2018.
 * Copyright (C) Binar::Apps, 2017
 * All rights reserved.
 */
public interface MyStudentsContract {

    interface View{
        void refreshView(List<Student> students);
    }

    interface Presenter{
        void loadMyTutors();
    }
}
