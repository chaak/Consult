package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by JakubWitczak on 19.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
@StringDef
@Retention(RetentionPolicy.SOURCE)
public @interface UserItems {
    String TUTOR_LIST = "tutor_list";
}
