package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.PagerAdapterItem.BIO_TAB;
import static app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.PagerAdapterItem.CHEMISTRY_TAB;
import static app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.PagerAdapterItem.GEO_TAB;
import static app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.PagerAdapterItem.MATH_TAB;
import static app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.PagerAdapterItem.PHYSIC_TAB;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by JakubWitczak on 10.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
@Retention(SOURCE)
@IntDef({MATH_TAB,
        GEO_TAB,
        BIO_TAB,
        CHEMISTRY_TAB,
        PHYSIC_TAB})
public @interface PagerAdapterItem {
    int MATH_TAB = 0;
    int GEO_TAB = 1;
    int BIO_TAB = 2;
    int CHEMISTRY_TAB = 3;
    int PHYSIC_TAB = 4;

}
