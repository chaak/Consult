package app.consult.witczak.jakub.com.concultapp.utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static app.consult.witczak.jakub.com.concultapp.utils.UserKey.IS_STUDENT;
import static app.consult.witczak.jakub.com.concultapp.utils.UserKey.STUDENT_LIST;
import static app.consult.witczak.jakub.com.concultapp.utils.UserKey.TUTOR_LIST;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by JakubWitczak on 15.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
@Retention(SOURCE)
@StringDef({
        IS_STUDENT,
        STUDENT_LIST,
        TUTOR_LIST
})
public @interface UserKey {
    String IS_STUDENT = "is_student";
    String STUDENT_LIST = "student_list";
    String TUTOR_LIST = "tutor_list";
}
