package app.consult.witczak.jakub.com.concultapp.utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.BIRTHDAY;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.EMAIL;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.FIRST_NAME;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.LAST_NAME;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.PHONE_NUMBER;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.PROFILE_PHOTO;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.TASK_LIST;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.USERNAME;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by JakubWitczak on 15.11.2017.
 * Copyright (C) Binar::Apps, 2017
 * All rights reserved.
 */
@Retention(SOURCE)
@StringDef({
        FIRST_NAME,
        LAST_NAME,
        EMAIL,
        PHONE_NUMBER,
        BIRTHDAY,
        PROFILE_PHOTO,
        TASK_LIST,
        USERNAME
})
public @interface StudentKey {
    String FIRST_NAME = "first_name";
    String LAST_NAME = "last_name";
    String EMAIL = "email";
    String PHONE_NUMBER = "phone_number";
    String BIRTHDAY = "birthday";
    String PROFILE_PHOTO = "profile_image";
    String TASK_LIST = "taskList";
    String USERNAME = "username";
}
