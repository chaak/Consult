package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.geography;

import android.util.Log;

import com.parse.ParseQuery;

import app.consult.witczak.jakub.com.concultapp.model.Tutor;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.TutorsCategory;

/**
 * Created by JakubWitczak on 10.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class GeoTutorsListPresenter implements GeoTutorsListContract.Presenter {

    private GeoTutorsListContract.View view;

    public GeoTutorsListPresenter(GeoTutorsListContract.View view) {
        this.view = view;
    }

    @Override
    public void loadTutors() {
        ParseQuery<Tutor> query = ParseQuery.getQuery(TutorsCategory.TUTOR);
        query.whereEqualTo(TutorsCategory.CATEGORY, TutorsCategory.GEO);
        query.findInBackground((geoTutors, e) -> {
            if (e == null) {
                view.refreshView(geoTutors);
            } else {
                // TODO: 12.12.2017 wyswietl komunikat do usera ze nie ma tych tutorow
                Log.d("Math Tutors", "Error " + e.getMessage());
            }
        });
    }
}
