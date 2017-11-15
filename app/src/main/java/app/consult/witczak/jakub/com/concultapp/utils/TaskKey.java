package app.consult.witczak.jakub.com.concultapp.utils;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static app.consult.witczak.jakub.com.concultapp.utils.TaskKey.CATEGORY;
import static app.consult.witczak.jakub.com.concultapp.utils.TaskKey.DESCRIPTION;
import static app.consult.witczak.jakub.com.concultapp.utils.TaskKey.IMAGE_PATH;
import static app.consult.witczak.jakub.com.concultapp.utils.TaskKey.STUDENT;
import static app.consult.witczak.jakub.com.concultapp.utils.TaskKey.TITLE;
import static app.consult.witczak.jakub.com.concultapp.utils.TaskKey.TO_DELETE;
import static app.consult.witczak.jakub.com.concultapp.utils.TaskKey.TUTOR;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by JakubWitczak on 15.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
@Retention(SOURCE)
@StringDef({
        TITLE,
        CATEGORY,
        DESCRIPTION,
        TO_DELETE,
        IMAGE_PATH,
        STUDENT,
        TUTOR
})
public @interface TaskKey {
    String TITLE = "title";
    String CATEGORY = "category";
    String DESCRIPTION = "description";
    String TO_DELETE = "to_delete";
    String IMAGE_PATH = "image_path";
    String STUDENT = "student";
    String TUTOR = "tutor";
}
