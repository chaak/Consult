package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.list.physic;

import android.util.Log;

import com.parse.ParseQuery;

import app.consult.witczak.jakub.com.concultapp.model.Tutor;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.TutorsCategory;

/**
 * Created by JakubWitczak on 10.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class PhysicTutorsListPresenter implements PhysicTutorsListContract.Presenter {

    private PhysicTutorsListContract.View view;

    public PhysicTutorsListPresenter(PhysicTutorsListContract.View view) {
        this.view = view;
    }

    @Override
    public void loadTutors() {
        ParseQuery<Tutor> query = ParseQuery.getQuery(TutorsCategory.TUTOR);
        query.whereEqualTo(TutorsCategory.CATEGORY, TutorsCategory.PHYS);
        query.findInBackground((chemTutors, e) -> {
            if (e == null) {
                view.refreshView(chemTutors);
            } else {
                // TODO: 12.12.2017 wyswietl komunikat do usera ze nie ma tych tutorow
                Log.d("Math Tutors", "Error " + e.getMessage());
            }
        });
    }
}
