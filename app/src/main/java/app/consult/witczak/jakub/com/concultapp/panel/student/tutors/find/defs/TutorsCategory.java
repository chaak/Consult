package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.TutorsCategory.BIO;
import static app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.TutorsCategory.CATEGORY;
import static app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.TutorsCategory.CHEM;
import static app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.TutorsCategory.GEO;
import static app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.TutorsCategory.MATH;
import static app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.TutorsCategory.PHYS;
import static app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.TutorsCategory.TUTOR;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by JakubWitczak on 12.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
@Retention(SOURCE)
@StringDef({
        TUTOR,
        CATEGORY,
        MATH,
        BIO,
        PHYS,
        GEO,
        CHEM})
public @interface TutorsCategory {
    String TUTOR = "Tutor";
    String CATEGORY = "category";
    String MATH = "Matematyka";
    String BIO = "Biologia";
    String PHYS = "Fizyka";
    String GEO = "Geografia";
    String CHEM = "Chemia";
}
