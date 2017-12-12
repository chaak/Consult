package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.details;

/**
 * Created by JakubWitczak on 12.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class TutorDetailsPresenter implements TutorDetailsContract.Presenter {

    private TutorDetailsContract.View view;

    public TutorDetailsPresenter(TutorDetailsContract.View view) {
        this.view = view;
    }
}
