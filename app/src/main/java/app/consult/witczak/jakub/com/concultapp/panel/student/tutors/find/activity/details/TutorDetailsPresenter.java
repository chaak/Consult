package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.activity.details;

/**
 * Created by JakubWitczak on 17.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class TutorDetailsPresenter implements TutorDetailsContract.Presenter {

    private TutorDetailsContract.View view;

    public TutorDetailsPresenter(TutorDetailsContract.View view) {
        this.view = view;
    }
}
