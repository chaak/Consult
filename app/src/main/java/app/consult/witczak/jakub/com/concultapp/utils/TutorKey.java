package app.consult.witczak.jakub.com.concultapp.utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static app.consult.witczak.jakub.com.concultapp.utils.TutorKey.BIRTHDAY;
import static app.consult.witczak.jakub.com.concultapp.utils.TutorKey.CATEGORY;
import static app.consult.witczak.jakub.com.concultapp.utils.TutorKey.DESCRIPTION;
import static app.consult.witczak.jakub.com.concultapp.utils.TutorKey.EMAIL;
import static app.consult.witczak.jakub.com.concultapp.utils.TutorKey.FIRST_NAME;
import static app.consult.witczak.jakub.com.concultapp.utils.TutorKey.LAST_NAME;
import static app.consult.witczak.jakub.com.concultapp.utils.TutorKey.PHONE_NUMBER;
import static app.consult.witczak.jakub.com.concultapp.utils.TutorKey.PROFILE_PHOTO;
import static app.consult.witczak.jakub.com.concultapp.utils.TutorKey.STUDENT_LIST;
import static app.consult.witczak.jakub.com.concultapp.utils.TutorKey.TASK_LIST;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by JakubWitczak on 15.11.2017.
 * Copyright (C), 2017
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
        STUDENT_LIST,
        CATEGORY
})
public @interface TutorKey {
    String FIRST_NAME = "first_name";
    String LAST_NAME = "last_name";
    String EMAIL = "email";
    String PHONE_NUMBER = "phone_number";
    String BIRTHDAY = "birthday";
    String DESCRIPTION = "description";
    String PROFILE_PHOTO = "profile_photo";
    String TASK_LIST = "taskList";
    String STUDENT_LIST = "student_list";
    String CATEGORY = "category";
}
