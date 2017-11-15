package app.consult.witczak.jakub.com.concultapp.utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.BIRTHDAY;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.DESCRIPTION;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.EMAIL;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.FIRST_NAME;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.LAST_NAME;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.PHONE_NUMBER;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.PROFILE_PHOTO;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.TASK_LIST;
import static app.consult.witczak.jakub.com.concultapp.utils.StudentKey.TUTOR_LIST;
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
        DESCRIPTION,
        PROFILE_PHOTO,
        TASK_LIST,
        TUTOR_LIST,
})
public @interface StudentKey {
    String FIRST_NAME = "first_name";
    String LAST_NAME = "last_name";
    String EMAIL = "email";
    String PHONE_NUMBER = "phone_number";
    String BIRTHDAY = "birthday";
    String DESCRIPTION = "description";
    String PROFILE_PHOTO = "profile_image_path";
    String TASK_LIST = "taskList";
    String TUTOR_LIST = "tutor_list";
}
