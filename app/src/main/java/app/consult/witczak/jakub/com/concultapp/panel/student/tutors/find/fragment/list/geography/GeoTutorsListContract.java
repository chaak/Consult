package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.list.geography;

import java.util.List;

import app.consult.witczak.jakub.com.concultapp.model.Tutor;

/**
 * Created by JakubWitczak on 10.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public interface GeoTutorsListContract {

    interface View {
        void refreshView(List<Tutor> tutors);
    }

    interface Presenter {
        void loadTutors();
    }
}
