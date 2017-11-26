package app.consult.witczak.jakub.com.concultapp.utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static app.consult.witczak.jakub.com.concultapp.utils.UserKey.BIRTHDAY;
import static app.consult.witczak.jakub.com.concultapp.utils.UserKey.CATEGORY;
import static app.consult.witczak.jakub.com.concultapp.utils.UserKey.FIRST_NAME;
import static app.consult.witczak.jakub.com.concultapp.utils.UserKey.IS_STUDENT;
import static app.consult.witczak.jakub.com.concultapp.utils.UserKey.LAST_NAME;
import static app.consult.witczak.jakub.com.concultapp.utils.UserKey.PHONE_NUMBER;
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
        TUTOR_LIST,
        FIRST_NAME,
        LAST_NAME,
        PHONE_NUMBER,
        BIRTHDAY,
        CATEGORY
})
public @interface UserKey {
    String IS_STUDENT = "is_student";
    String STUDENT_LIST = "student_list";
    String TUTOR_LIST = "tutor_list";
    String FIRST_NAME = "first_name";
    String BIRTHDAY = "birthday";
    String LAST_NAME = "last_name";
    String PHONE_NUMBER = "phone_number";
    String CATEGORY = "category";
}
